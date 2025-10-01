package com.restaurant.rms.controllers;

import com.restaurant.rms.models.DTO.EmployeeShiftDTO;
import com.restaurant.rms.models.EmployeeShift;
import com.restaurant.rms.repository.EmployeeShiftRepo;
import jakarta.validation.Valid;
//import models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
//import services.EmployeeShiftRepo;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/employee-shifts")
public class EmployeeShiftController {
    @Autowired
    private EmployeeShiftRepo employeeShiftRepo;
//    EmployeeShiftDTO employeeShiftDTO = new EmployeeShiftDTO();
    // --------------------------------------------

    // READ
//    @GetMapping({"","/"})
//    public String showEmployeeShift (Model model){
//        List<EmployeeShift> EmployeeShift = employeeShiftRepo.findAll();
//        model.addAttribute("EmployeeShift", EmployeeShift);
//        return "EmployeeShift/shifts";
//
//    }

    @GetMapping("")
    public String getAllShifts(Model model) {
        System.out.println("\n***Employee-shift");
        System.out.println("Attempting to get data...");
        List<EmployeeShift> employeeShifts = employeeShiftRepo.findAll(Sort.by(Sort.Direction.DESC, "id"));
        model.addAttribute("EmployeeShifts", employeeShifts);
        return "employee-shift/employee-shifts";
    }

    // do later
//    @GetMapping("/list")
//    public String listEmployeeShifts(Model model) {
//        List<EmployeeShift> employees = employeeShiftRepo.findAll(Sort.by(Sort.Direction.DESC, "id"));
//        model.addAttribute("employees", employees);
//        return "shifts/listOfShifts";
//    }

    // maybe do later
    // Search
    //   @GetMapping("/employees/search")
//    public String searchEmployee(@RequestParam String employeeId, Model model) {
    //       Employee employee = employeeService.findById(employeeId);
    //       model.addAttribute("employee", employee);
//        return "employee-details"; // Your Thymeleaf template
    //  }


    // CREATE
    // Display Page
    @GetMapping("/add")
    public String showCreatePage(Model model){
        System.out.println("\n***Employee-shift");
        System.out.println("Attempting to get ADD page...");

        EmployeeShiftDTO employeeShiftDTO = new EmployeeShiftDTO();
        model.addAttribute("EmployeeShiftDTO", employeeShiftDTO);
        return "employee-shift/employee-shifts-add";
    }
    // Send data to database
    @PostMapping("/add")
    public String createShift(
            @Valid @ModelAttribute EmployeeShiftDTO employeeShiftDTO,
            BindingResult result
    ){
        if (result.hasErrors()){
            return "employee-shift/employee-shifts-add";
        }

        EmployeeShift employeeShift = new EmployeeShift();
        employeeShift.setStartTime(employeeShiftDTO.getStartTime());
        employeeShift.setEndTime(employeeShiftDTO.getEndTime());
        employeeShift.setDateNow(LocalDateTime.now());

        System.out.println("\n***Employee-shift");
        System.out.println("Attempting to add data...");
        System.out.println("\nRecord");
        System.out.println(employeeShift);
        employeeShiftRepo.save(employeeShift);

        return "redirect:/employee-shifts";
    }

    // UPDATE
    // Get edit page
    @GetMapping ("/edit")
    public String showEditShiftsPage(
            Model model,
            @RequestParam int id
    ){
        System.out.println("\n***Employee-shift");
        System.out.println("Attempting to get EDIT page...");
        try{
//            EmployeeShift employeeShifts = employeeShiftRepo.findById(id).get();
            EmployeeShift employeeShifts = employeeShiftRepo.findById(id).orElse(null);
            System.out.println("\nRecord: " + employeeShifts);

            EmployeeShiftDTO employeeShiftDTO = new EmployeeShiftDTO();
            employeeShiftDTO.setDateNow(employeeShifts.getDateNow());
            employeeShiftDTO.setStartTime(employeeShifts.getStartTime());
            employeeShiftDTO.setEndTime(employeeShifts.getEndTime());

            model.addAttribute("employeeShift", employeeShifts);
            model.addAttribute("employeeShiftsDTO", employeeShiftDTO);
        }
        catch (Exception ex){
            System.out.println("Exception: " + ex.getMessage());
            return "redirect:/employee-shift";
        }
        return "employee-shift/employee-shifts-edit";
    }

    @PostMapping("/edit")
    public String editEmployeeShifts(
            Model model,
            @RequestParam int id,
            @Valid @ModelAttribute EmployeeShiftDTO employeeShiftsDTO,
            BindingResult result
    ){
        try{
            EmployeeShift employeeShift = employeeShiftRepo.findById(id).get();
            model.addAttribute("EmployeeShifts", employeeShift);

            if (result.hasErrors()){
                return "employee-shift/employee-shifts-edit";
            }

            employeeShift.setStartTime(employeeShiftsDTO.getStartTime());
            employeeShift.setEndTime(employeeShiftsDTO.getEndTime());

            System.out.println("\n***Employee-shift");
            System.out.println("Attempting to edit data...");
            System.out.println(employeeShift);
            employeeShiftRepo.save(employeeShift);
        }
        catch (Exception ex){
            System.out.println("Exception: " + ex.getMessage());
        }
        return "redirect:/employee-shifts";
    }

    // DELETE
    @GetMapping("/delete")
    public String deleteEmployeeShift(@RequestParam int id) {
        try {
            EmployeeShift employeeShift = employeeShiftRepo.findById(id).get();

            // delete from database
            employeeShiftRepo.delete(employeeShift);
            System.out.println("\n***Successful deletion of:");
            System.out.println(employeeShift);
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return "redirect:/employee-shifts";
    }
    // --------------------------------------------
}
