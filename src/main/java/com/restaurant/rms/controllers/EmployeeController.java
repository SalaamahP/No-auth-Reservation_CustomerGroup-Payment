package com.restaurant.rms.controllers;

import com.restaurant.rms.models.Employee;
import com.restaurant.rms.models.DTO.EmployeeDTO;
import com.restaurant.rms.models.EmployeeSalary;
import com.restaurant.rms.repository.EmployeeRepo;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.util.Date;
import java.util.List;


/**
 * EMPLOYEE
 * <br>
 * Used for operations related to the Employee entity
 * */
@Controller
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeRepo empRepo;
    // --------------------------------------------


    // GET ALL
    @GetMapping({"", "/"})
    public String getAllEmployees(Model model) {
        List<Employee> employees = empRepo.findAll(Sort.by(Sort.Direction.DESC, "id"));
        for (Employee e : employees){
            System.out.println("- " + e);
        }
        model.addAttribute("employees", employees);
        return "employee/employees";
    }

//    @GetMapping("/list")
//    public String listEmployees(Model model) {
//        List<Employee> employees = empRepo.findAll(Sort.by(Sort.Direction.DESC, "id"));
//
//        for (Employee e : employees){
//            System.out.println("- " + e);
//        }
//        model.addAttribute("employees", employees);
//        return "employee/employees-list";
//    }
    // --------------------------------------------


    // Other
//    @GetMapping("/pay")
//    public String employeesPay() {
//        return "employee/employees-pay";
//    }

    // ADD
    @GetMapping("/add")
    public String showAddPage(Model model) {
        EmployeeDTO empDTO = new EmployeeDTO();
        model.addAttribute("employeeDTO", empDTO);
        return "employee/employees-add";
    }

    @PostMapping("/add")
    public String addEmployee(
            @Valid @ModelAttribute EmployeeDTO eDTO,
            BindingResult result
    ) {
        // checking for errors from the form
        if (result.hasErrors()) {
            System.out.println(result.getAllErrors());
            return "employee/employees-add";
        }

        // creating the object
        Date currentDate = new Date();
        Employee emp = new Employee(
                eDTO.getEmpFirstName(),
                eDTO.getEmpLastName(),
                currentDate,
                eDTO.getRole(),
                eDTO.getEmpContactNum(),
                eDTO.getEmpEmail()
        );

        // saving to database
        this.empRepo.save(emp);
        System.out.println("\n***Employee-object \n(" + emp + ") \nadded successfully***");

        // re-directing
        return "redirect:/employees";
    }
    // --------------------------------------------


    // EDIT
    // getting existing data of the product and displaying it on the update page
    @GetMapping("/edit")
    public String showEditPage(
            Model model,
            @RequestParam int id
    ) {
        System.out.println("\n***(EDIT) Getting...");
        try {
            Employee employee = empRepo.findById(id).get();
            EmployeeDTO empDTO = new EmployeeDTO();

            empDTO.setEmpFirstName(employee.getEmpFirstName());
            empDTO.setEmpLastName(employee.getEmpLastName());
            empDTO.setRole(employee.getRole());

            model.addAttribute("employee", employee);
            model.addAttribute("employeeDTO", empDTO);
        }
        catch (Exception ex) {
            System.out.println("Exception" + ex.getMessage());
            return "redirect:/employee";
        }
        return "employee/employees-edit";
    }

    // Editing an existing record
    @PostMapping("/edit")
    public String editEmployee(
            Model model,
            @RequestParam int id,
            @Valid @ModelAttribute EmployeeDTO EmployeeDTO,
            BindingResult result
    ) {
        System.out.println("\n***(EDIT) Putting...");

        try {
            Employee employee = empRepo.findById(id).get();
            model.addAttribute("employeeDTO", employee);

            if (result.hasErrors()) {
                return "employee/employees-edit";
            }

            // updating other details
            employee.setRole(EmployeeDTO.getRole());
            employee.setEmpFirstName(EmployeeDTO.getEmpFirstName());
            employee.setEmpLastName(EmployeeDTO.getEmpLastName());
            employee.setEmpEmail(EmployeeDTO.getEmpEmail());
            employee.setEmpContactNum(EmployeeDTO.getEmpContactNum());

            System.out.println("\nRecord: \n" + employee);
            empRepo.save(employee);
            System.out.println("\n***Updated employee successfully");
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return "redirect:/employees";
    }
    // --------------------------------------------


    // DELETE
    @GetMapping("/delete")
    public String deleteEmployee(@RequestParam int id) {
        try {
            Employee employee = empRepo.findById(id).get();

            // delete from database
            empRepo.delete(employee);
            System.out.println("\n***Successful deletion of:");
            System.out.println(employee);
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return "redirect:/employees";
    }
    // --------------------------------------------

}
