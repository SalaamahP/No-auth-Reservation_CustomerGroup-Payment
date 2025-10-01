package com.restaurant.rms.service;

import com.restaurant.rms.models.MenuItem;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class MenuItemServiceTest {
    @Autowired
    MenuItemService service;

    MenuItem menuItem = new MenuItem(
            "menuItem_name1",
            "menuItem_num1",
            1.05,
            "vegetable",
            5
    );

    MenuItem menuItem1 = new MenuItem(
            "memuItem_name100",
            "menuItem_num100",
            20.4,
            "vegan",
            10
    );
    // ------------------------------------

    @Test
    @Order(1)
    void add() {
        MenuItem addMenuItem = service.add(menuItem1);
        System.out.println(addMenuItem);
        assertNotNull(addMenuItem);
    }

    @Test
    @Order(2)
    void read() {

        MenuItem menuItemRead = service.read(2);
        System.out.println(menuItemRead);
        assertNotNull(menuItemRead);
    }

    @Test
    @Order(3)
    void update() {
        MenuItem menuItemUpdate = service.update(menuItem);
        System.out.println(menuItemUpdate);
        assertNotNull(menuItemUpdate);
    }

    @Test
    @Order(4)
    void delete() {
        System.out.println("Attempting to delete: \n" + menuItem1);
        Boolean menuItemDelete = service.delete(menuItem1.getMenuItemId());
        System.out.println(menuItemDelete);
        assertTrue(menuItemDelete);
    }

    @Test
    @Order(5)
    void getAll(){
        List<MenuItem> menuItemList = service.getAll();
        System.out.println("\nMenuItem");

        for (MenuItem emp : menuItemList){
            System.out.println(emp);
        }
        assertNotNull(menuItemList);
    }
}
