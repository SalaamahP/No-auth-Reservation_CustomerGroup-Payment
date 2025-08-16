package com.restaurant.rms.service;

import com.restaurant.rms.models.Order;
import org.junit.jupiter.api.MethodOrderer;
//import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class OrderServiceTest {
    @Autowired
    OrderService service;

    /*
    * Statuses
    * - not-started
    * - in-progress
    * - complete
    */
    LocalDateTime now = LocalDateTime.now();
    Order order = new Order(
            now,
            10.0,
            190.0,
            "not-started"
    );
    // ------------------------------------

    @Test
    void a_add() {
        Order orderAdd = service.add(order);
        System.out.println(orderAdd);
        assertNotNull(orderAdd);
    }

    @Test
    void b_read() {
        Order orderRead = service.get(1);
        System.out.println(orderRead);
        assertNotNull(orderRead);
    }

    @Test
    void c_update() {
        LocalDateTime now1 = LocalDateTime.now();
        Order order1 = new Order(
                now1,
                5.0,
                120.0,
                "in-progress"
        );

        Order orderUpdate = service.update(order1);
        System.out.println(orderUpdate);
        assertNotNull(orderUpdate);
    }

    @Test
    void d_delete() {
        System.out.println("Attempting to delete: \n" + order);
        Boolean employeeDelete = service.delete(order.getId());
        System.out.println(employeeDelete);
        assertTrue(employeeDelete);
    }

    @Test
    void e_getAll(){
        List<Order> orderList = service.getAll();

        System.out.println("\nOrders");
        for (Order emp : orderList){
            System.out.println(emp);
        }
        assertNotNull(orderList);
    }
}