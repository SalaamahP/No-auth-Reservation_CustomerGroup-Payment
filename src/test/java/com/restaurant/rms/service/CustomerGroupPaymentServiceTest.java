package com.restaurant.rms.service;

import com.restaurant.rms.models.*;
import com.restaurant.rms.repository.CustomerGroupRepo;
import com.restaurant.rms.repository.RestaurantTableRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CustomerGroupPaymentServiceTest {
    @Autowired
    CustomerGroupPaymentService customerGroupPaymentService;

    @Autowired
    CustomerGroupRepo customerGroupRepo;

    CustomerGroupPayment customerGroupPayment;

    @BeforeEach
    void setUp() {
        CustomerGroup customerGroup = new CustomerGroup();
        customerGroup.setFirstName("Alice");
        customerGroup.setLastName("Black");
        customerGroup.setPhoneNumber("0872444811");
        customerGroup.setNumberOfPeople(2);

        customerGroup = customerGroupRepo.save(customerGroup);

        customerGroupPayment = new CustomerGroupPayment();
        customerGroupPayment.setPaymentDateTime(LocalDateTime.now());
        customerGroupPayment.setPaymentAmount(250.00);
        customerGroupPayment.setPaymentTransactionType("CARD");
        customerGroupPayment.setCustomerGroup(customerGroup);

        customerGroupPaymentService.add(customerGroupPayment);

    }

    @Test
    @Order(1)
    void add() {
        CustomerGroupPayment addPayment = customerGroupPaymentService.add(customerGroupPayment);
        customerGroupPayment.setPaymentId(addPayment.getPaymentId());
        System.out.println(addPayment);
        assertNotNull(addPayment);
    }

    @Test
    @Order(2)
    void read() {
        CustomerGroupPayment readPayment = customerGroupPaymentService.read(customerGroupPayment.getPaymentId());
        System.out.println(readPayment);
        assertNotNull(readPayment);
    }

    @Test
    @Order(4)
    void getAll() {
        List<CustomerGroupPayment> allPayments = customerGroupPaymentService.getAll();
        allPayments.forEach(System.out::println);
        assertFalse(allPayments.isEmpty());
    }

    @Test
    @Order(3)
    void update() {
        customerGroupPayment.setPaymentAmount(500.00);
        CustomerGroupPayment updatePayment = customerGroupPaymentService.update(customerGroupPayment);
        System.out.println(updatePayment);
        assertEquals(500.00, updatePayment.getPaymentAmount());
    }

    @Test
    @Order(5)
    void delete() {
        boolean deletePayment = customerGroupPaymentService.delete(customerGroupPayment.getPaymentId());
        System.out.println("Deleted payment " + deletePayment);
        assertTrue(deletePayment);
    }
}
