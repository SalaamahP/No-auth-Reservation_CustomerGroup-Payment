package com.restaurant.rms.service;

import com.restaurant.rms.models.RestaurantTable;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class RestaurantTableServiceTest {
    @Autowired
    RestaurantTableService service;

    Date currentDate = new Date();
    RestaurantTable table = new RestaurantTable(
            1,
            5,
            "status1",
            currentDate
    );

    RestaurantTable table1 = new RestaurantTable(
            100,
            500,
            "status100",
            currentDate
    );


    @Test
    @Order(1)
    void add() {
        RestaurantTable addTable = service.add(table1);
        System.out.println(addTable);
        assertNotNull(addTable);
    }

    @Test
    @Order(2)
    void read() {

        RestaurantTable tableRead = service.read(3);
        System.out.println(tableRead);
        assertNotNull(tableRead);
    }

    @Test
    @Order(3)
    void update() {
        RestaurantTable tableUpdate = service.update(table);
        System.out.println(tableUpdate);
        assertNotNull(tableUpdate);
    }

    @Test
    @Order(4)
    void delete() {
        System.out.println("Attempting to delete: \n" + table1);
        Boolean tableDelete = service.delete(table1.getId());
        System.out.println(tableDelete);
        assertTrue(tableDelete);
    }

    @Test
    @Order(5)
    void getAll(){
        List<RestaurantTable> restaurantTableList = service.getAll();

        System.out.println("\nTables:   ");
        for (RestaurantTable tab : restaurantTableList){
            System.out.println(tab);
        }
        assertNotNull(restaurantTableList);
    }
}
