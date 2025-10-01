package com.restaurant.rms.service;

import com.restaurant.rms.models.CustomerGroup;
import com.restaurant.rms.models.CustomerGroupPayment;
import com.restaurant.rms.repository.CustomerGroupRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;

import java.time.LocalDateTime;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CustomerGroupServiceTest {
    @Autowired
    CustomerGroupService customerGroupService;

    @Autowired
    CustomerGroupRepo customerGroupRepo;

    private CustomerGroup customerGroup;

    @BeforeEach
    void setUp() {
        customerGroup = new CustomerGroup();
        customerGroup.setFirstName("Winona");
        customerGroup.setLastName("Ryder");
        customerGroup.setPhoneNumber("0772444811");
        customerGroup.setNumberOfPeople(2);

        customerGroup = customerGroupRepo.save(customerGroup);
    }

    @Test
    @Order(1)
    void add() {
        CustomerGroup addCustomerGroup = customerGroupService.add(customerGroup);
    }

    @Test
    @Order(2)
    void read() {
        CustomerGroup readGroup = customerGroupService.read(customerGroup.getCustomerGroupId());
        System.out.println(readGroup);
        assertNotNull(readGroup);
    }

    @Test
    @Order(4)
    void getAll() {
        List<CustomerGroup> allGroups = customerGroupService.getAll();
        allGroups.forEach(System.out::println);
        assertFalse(allGroups.isEmpty());
    }

    @Test
    @Order(3)
    void update() {
        customerGroup.setFirstName("Wise");
        CustomerGroup update = customerGroupService.update(customerGroup);
        System.out.println(update);
        assertEquals("Wise", update.getFirstName());
    }

    @Test
    @Order(5)
    void delete() {
        boolean deleteGroup = customerGroupService.delete(customerGroup.getCustomerGroupId());
        System.out.println("Deleted group " + deleteGroup);
        assertTrue(deleteGroup);
    }

}
