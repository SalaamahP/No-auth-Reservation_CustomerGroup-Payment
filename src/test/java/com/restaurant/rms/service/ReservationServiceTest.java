package com.restaurant.rms.service;

import com.restaurant.rms.models.CustomerGroup;
import com.restaurant.rms.models.Reservation;
import com.restaurant.rms.models.ReservationId;
import com.restaurant.rms.models.RestaurantTable;
import com.restaurant.rms.repository.CustomerGroupRepo;
import com.restaurant.rms.repository.RestaurantTableRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;

import java.sql.SQLOutput;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@Deprecated
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ReservationServiceTest {
    @Autowired
    ReservationService reservationService;

    @Autowired
    RestaurantTableRepo restaurantTableRepo;

    @Autowired
    CustomerGroupRepo customerGroupRepo;

    Reservation reservation;
    ReservationId reservationId;

    @BeforeEach
    void setUp() {
        CustomerGroup customerGroup = new CustomerGroup();
        customerGroup.setFirstName("John");
        customerGroup.setLastName("Smith");
        customerGroup.setPhoneNumber("0872365811");
        customerGroup.setNumberOfPeople(4);

        customerGroup = customerGroupRepo.save(customerGroup);

        RestaurantTable restaurantTable = new RestaurantTable();
        restaurantTable.setTableNumber(8);
        restaurantTable=restaurantTableRepo.save(restaurantTable);

        reservationId = new ReservationId(UUID.randomUUID(), customerGroup.getCustomerGroupId());

        reservation = new Reservation();
        reservation.setId(reservationId);
        reservation.setCustomerGroup(customerGroup);
//        reservation.setRestaurantTable(restaurantTable);
        reservation.setReservationDateTime(LocalDateTime.now());
        reservation.setReservationTimeMax(20);
        reservation.setReservationTimeStart(LocalDateTime.now());
        reservation.setReservationTimeEnd(LocalDateTime.now().plusMinutes(20));
        reservationService.add(reservation);


    }
    @Test
    @Order(1)
    void add() {
        Reservation addReservation = reservationService.add(reservation);
        reservationId = addReservation.getId();
        System.out.println("Add reservation: " + addReservation);
        assertNotNull(addReservation);

    }

    @Test
    @Order(2)
    void read() {
        Reservation readReservation = reservationService.read(reservationId);
        System.out.println("Read reservation: " + readReservation);
        assertNotNull(readReservation);
        assertEquals(reservationId, readReservation.getId());
    }

    @Test
    @Order(4)
    void getAll() {
        List<Reservation> reservations = reservationService.getAll();
        System.out.println("Get all reservations: " + reservations);
        reservations.forEach(System.out::println);
        assertFalse(reservations.isEmpty());
    }

    @Test
    @Order(3)
    void update() {
        Reservation updateReservation = reservationService.update(reservation);
        System.out.println("Update reservation: " + updateReservation);
        assertNotNull(updateReservation);

    }

    @Test
    @Order(5)
    void delete() {
        reservationService.delete(reservationId);
        System.out.println("Delete reservation: " + reservationId);
        assertNull(reservationService.read(reservationId));
    }
}
