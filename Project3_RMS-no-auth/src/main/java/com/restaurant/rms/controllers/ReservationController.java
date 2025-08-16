package com.restaurant.rms.controllers;

import com.restaurant.rms.models.CustomerGroup;
import com.restaurant.rms.models.DTO.CustomerGroupDTO;
import com.restaurant.rms.models.DTO.ReservationDTO;
import com.restaurant.rms.models.Reservation;
import com.restaurant.rms.models.ReservationId;
import com.restaurant.rms.models.RestaurantTable;
import com.restaurant.rms.repository.CustomerGroupRepo;
import com.restaurant.rms.repository.ReservationRepo;
import com.restaurant.rms.repository.RestaurantTableRepo;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
//@RequestMapping("reservations")
@RequestMapping("/reservations")
public class ReservationController {
    @Autowired
    private ReservationRepo reservationRepo;

    @Autowired
    private CustomerGroupRepo customerGroupRepo;

    @Autowired
    RestaurantTableRepo restaurantTableRepo;

//    @RequestMapping("/reservations")
//    public String reservations(){
//        return "reservation/reservations";
//    }

    @GetMapping("/add")
//    @GetMapping("/reservations-add")
    public String addReservation(Model model) {
        ReservationDTO reservationDTO = new ReservationDTO();
        reservationDTO.setCustomerGroup(new CustomerGroupDTO());
        model.addAttribute("reservationDTO", reservationDTO);
        return "reservation/reservations-add";
    }

    @PostMapping("/add")
//    @PostMapping("/reservations-add")
    public String createReservation(@Valid @ModelAttribute ReservationDTO rDTO,
                                    BindingResult result,
                                    Model model
    ) {
        if (rDTO.getReservationDateTime() != null && rDTO.getReservationDateTime().isBefore(LocalDateTime.now())) {
            model.addAttribute("errors", "Reservation date/time is before current date.");
            return "reservation/reservations-add";
        }

        if (rDTO.getReservationTimeStart() != null && rDTO.getReservationTimeEnd() != null &&
                !rDTO.getReservationTimeEnd().isAfter(rDTO.getReservationTimeStart())) {
            model.addAttribute("errors", "End time must be after start time.");
            return "reservation/reservations-add";

        }
        if (rDTO.getReservationTimeStart() != null && rDTO.getReservationTimeEnd() != null &&
                java.time.Duration.between(rDTO.getReservationTimeStart(), rDTO.getReservationTimeEnd()).toMinutes() > rDTO.getReservationTimeMax()) {
            model.addAttribute("errors", "Reservation time exceeds maximum time limit.");
            return "reservation/reservations-add";
        }

        if (result.hasErrors()) {
            model.addAttribute("errors", "Validation errors occurred.");
            System.out.println(result.getAllErrors());
            return "reservation/reservations-add";
        }

        CustomerGroupDTO customerGroupDTO = rDTO.getCustomerGroup();
        if (customerGroupDTO == null || customerGroupDTO.getFirstName() == null || customerGroupDTO.getPhoneNumber() == null) {
            model.addAttribute("errors", "Customer information missing");
            return "reservation/reservations-add";
        }

        Optional<CustomerGroup> existingGroup = customerGroupRepo.findByPhoneNumber(customerGroupDTO.getPhoneNumber());

        CustomerGroup customerGroup;
        if (existingGroup.isPresent()) {
            customerGroup = existingGroup.get();
            model.addAttribute("info", "Customer group already exists."
                    + customerGroup.getFirstName() + " " + customerGroup.getLastName());


        } else {

            CustomerGroup newCustomerGroup = new CustomerGroup();
            newCustomerGroup.setFirstName(customerGroupDTO.getFirstName());
            newCustomerGroup.setLastName(customerGroupDTO.getLastName());
            newCustomerGroup.setPhoneNumber(customerGroupDTO.getPhoneNumber());
            newCustomerGroup.setNumberOfPeople(customerGroupDTO.getNumberOfPeople());

            customerGroup = customerGroupRepo.save(newCustomerGroup);
        }

        RestaurantTable table = restaurantTableRepo.findById(rDTO.getTableId())
                .orElseThrow();

        boolean exists = reservationRepo.existsByRestaurantTableAndReservationDateTime(table, rDTO.getReservationDateTime());
        if (exists) {
            model.addAttribute("errors", "Table already reserved for selected date/time.");
            return "reservation/reservations-add";
        }
        UUID rId = UUID.randomUUID();
        ReservationId reservationId = new ReservationId(rId, customerGroup.getCustomerGroupId());

        Reservation reservation = new Reservation();
        reservation.setId(reservationId);
        reservation.setCustomerGroup(customerGroup);

        reservation.setReservationDateTime(rDTO.getReservationDateTime());
        reservation.setReservationTimeMax(rDTO.getReservationTimeMax());
        reservation.setReservationTimeStart(rDTO.getReservationTimeStart());
        reservation.setReservationTimeEnd(rDTO.getReservationTimeEnd());


        table = restaurantTableRepo.findById(rDTO.getTableId()).orElseThrow();

        reservation.setRestaurantTable(table);

        if (reservation.getId() == null ||
                reservation.getId().getUuid() == null) {
            model.addAttribute("errors", "Reservation id incomplete");
            return "reservation/reservations-add";
        }

        this.reservationRepo.save(reservation);
        System.out.println("\n***Reservation Added \n(" + reservation.getId() + ")");
        return "redirect:/reservations";
    }

    @GetMapping("/edit")
//    @GetMapping("/reservations/edit")
    public String editReservation(
            Model model,
            @RequestParam UUID uuid,
            @RequestParam int customerGroupId
    ) {

        ReservationId id = new ReservationId(uuid, customerGroupId);
        // System.out.println("\n***Reservation Edit \n(" + uuid + customerGroupId + ")");
        try {
            Reservation reservation = reservationRepo.findById(id).orElseThrow();

            ReservationDTO reservationDTO = new ReservationDTO();
            reservationDTO.setId(id);
            reservationDTO.setReservationDateTime(reservation.getReservationDateTime());
            reservationDTO.setReservationTimeMax(reservation.getReservationTimeMax());
            reservationDTO.setReservationTimeStart(reservation.getReservationTimeStart());
            reservationDTO.setReservationTimeEnd(reservation.getReservationTimeEnd());

            if (reservation.getRestaurantTable() != null) {
                reservationDTO.setTableId(reservation.getRestaurantTable().getId());
            }


            CustomerGroup group = reservation.getCustomerGroup();
            if (group != null) {
                CustomerGroupDTO groupDTO = new CustomerGroupDTO();
                groupDTO.setCustomerGroupId(group.getCustomerGroupId());
                groupDTO.setFirstName(group.getFirstName());
                groupDTO.setLastName(group.getLastName());
                groupDTO.setPhoneNumber(group.getPhoneNumber());
                groupDTO.setNumberOfPeople(group.getNumberOfPeople());
                reservationDTO.setCustomerGroup(groupDTO);
            }

            model.addAttribute("reservationDTO", reservationDTO);
            //model.addAttribute("reservation", reservationDTO);

        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
            return "redirect:/reservations";

        }
        return "reservation/reservations-edit";
    }

    @PostMapping("/edit")
    public String updateReservation(
            Model model,
            @Valid @ModelAttribute("reservationDTO") ReservationDTO resDTO,
            BindingResult result
    ) {
        if (resDTO.getReservationDateTime() != null && resDTO.getReservationDateTime().isBefore(LocalDateTime.now())) {
            model.addAttribute("errors", "Reservation date/time is before current date.");
            return "reservation/reservations-edit";
        }

        if (resDTO.getReservationTimeStart() != null && resDTO.getReservationTimeEnd() != null &&
                !resDTO.getReservationTimeEnd().isAfter(resDTO.getReservationTimeStart())) {
            model.addAttribute("errors", "End time must be after start time.");
            return "reservation/reservations-edit";

        }
        if (resDTO.getReservationTimeStart() != null && resDTO.getReservationTimeEnd() != null &&
                java.time.Duration.between(resDTO.getReservationTimeStart(), resDTO.getReservationTimeEnd()).toMinutes() > resDTO.getReservationTimeMax()) {
            model.addAttribute("errors", "Reservation time exceeds maximum time limit.");
            return "reservation/reservations-edit";
        }

        if (result.hasErrors()) {
            return "reservation/reservations-edit";
        }
        try {
            ReservationId id = resDTO.getId();
            Reservation reservation = reservationRepo.findById(id).orElseThrow();
            //model.addAttribute("resDTO", reservation);




            reservation.setReservationDateTime(resDTO.getReservationDateTime());
            reservation.setReservationTimeMax(resDTO.getReservationTimeMax());
            reservation.setReservationTimeStart(resDTO.getReservationTimeStart());
            reservation.setReservationTimeEnd(resDTO.getReservationTimeEnd());
            RestaurantTable table = restaurantTableRepo.findById(resDTO.getTableId()).orElseThrow();

            boolean exists = reservationRepo.existsByRestaurantTableAndReservationDateTime(table, resDTO.getReservationDateTime());
            if (exists && ! reservation.getReservationDateTime().equals(resDTO.getReservationDateTime())) {
                model.addAttribute("errors", "Table already reserved for selected date/time.");
                return "reservation/reservations-add";
            }

            reservation.setRestaurantTable(table);


            CustomerGroupDTO group = resDTO.getCustomerGroup();
            CustomerGroup updatedGroup = reservation.getCustomerGroup();

            Optional<CustomerGroup> existingGroup = customerGroupRepo.findByPhoneNumber(updatedGroup.getPhoneNumber());
            if (existingGroup.isPresent() && existingGroup.get().getCustomerGroupId() != updatedGroup.getCustomerGroupId()) {
                model.addAttribute("errors", "Customer group with this phone number already exists.");
                return "reservation/reservations-edit";
            }

            updatedGroup.setFirstName(group.getFirstName());
            updatedGroup.setLastName(group.getLastName());
            updatedGroup.setPhoneNumber(group.getPhoneNumber());
            updatedGroup.setNumberOfPeople(group.getNumberOfPeople());

            customerGroupRepo.save(updatedGroup);
            reservationRepo.save(reservation);
            System.out.println("\n Updated Reservation \n(" + reservation.getId() + ")");

        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return "redirect:/reservations";
    }

    @GetMapping("/delete")
//    @GetMapping("/reservations/delete")
    public String deleteReservation(
            @RequestParam("uuid") UUID uuid,
            @RequestParam("customerGroupId") int customerGroupId
    ) {

        try {
            ReservationId id = new ReservationId(uuid, customerGroupId);
            Reservation reservation = reservationRepo.findById(id).orElse(null);

            if (reservation != null) {
                reservationRepo.delete(reservation);
                System.out.println("\n Deleted Reservation \n(" + reservation.getId() + ")");
            }

        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return "redirect:/reservations/list";
    }

    @GetMapping("")
//    @RequestMapping("")
//    @RequestMapping("/reservations")
    public String allReservations(Model model) {
        List<Reservation> reservations = reservationRepo.findAll(Sort.by(Sort.Direction.ASC, "id"));
        model.addAttribute("reservations", reservations);
        return "reservation/reservations";
    }

    @GetMapping("/list")
//    @GetMapping("/reservations-list")
    public String reservationsList(Model model) {
        List<Reservation> reservations = reservationRepo.findAll(Sort.by(Sort.Direction.ASC, "id"));
        model.addAttribute("reservations", reservations);
        return "reservation/reservations-list";
    }


}
