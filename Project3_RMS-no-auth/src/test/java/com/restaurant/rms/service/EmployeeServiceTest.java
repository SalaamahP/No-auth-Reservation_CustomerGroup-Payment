package com.restaurant.rms.service;

import com.restaurant.rms.models.Employee;
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
class EmployeeServiceTest {
    @Autowired
    EmployeeService service;

    Date currentDate = new Date();
//    Employee emp = new Employee(
//            eDTO.getEmpFirstName(),
//            eDTO.getEmpLastName(),
//            currentDate,
//            eDTO.getRole(),
//            eDTO.getEmpContactNum(),
//            eDTO.getEmpEmail()
//    );

    Employee employee = new Employee(
            "first_name",
            "last_name",
            currentDate,
            "role1"
    );

    Employee employee1 = new Employee(
            "first_name100",
            "last_name100",
            currentDate,
            "role100"
    );
    // ------------------------------------

    @Test
    @Order(1)
    void add() {
        Employee addEmployee = service.add(employee1);
        System.out.println(addEmployee);
        assertNotNull(addEmployee);
    }

    @Test
    @Order(2)
    void read() {
//        Employee employeeRead = service.read(employee1.getId());
        Employee employeeRead = service.read(3);
        System.out.println(employeeRead);
        assertNotNull(employeeRead);
    }

    @Test
    @Order(3)
    void update() {
        Employee employeeUpdate = service.update(employee);
        System.out.println(employeeUpdate);
        assertNotNull(employeeUpdate);
    }

//    @Test
//    @Order(4)
    void delete() {
        System.out.println("Attempting to delete: \n" + employee1);
        Boolean employeeDelete = service.delete(employee1.getId());
//        Boolean employeeDelete = service.delete(2);
        System.out.println(employeeDelete);
        assertTrue(employeeDelete);
    }

    @Test
    @Order(5)
    void getAll(){
        List<Employee> employeeList = service.getAll();

        System.out.println("\nEmployees");
        for (Employee emp : employeeList){
            System.out.println(emp);
        }
        assertNotNull(employeeList);
    }
}