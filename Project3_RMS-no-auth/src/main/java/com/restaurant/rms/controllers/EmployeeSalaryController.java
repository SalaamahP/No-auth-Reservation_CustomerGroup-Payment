package com.restaurant.rms.controllers;

import com.restaurant.rms.models.DTO.UserDTO;
import com.restaurant.rms.models.Employee;
import com.restaurant.rms.models.EmployeeSalary;
import com.restaurant.rms.models.DTO.EmployeeSalaryDTO;
import com.restaurant.rms.repository.EmployeeRepo;
import com.restaurant.rms.repository.EmployeeSalaryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/salaries")
//@RequestMapping("/employee-salaries")
public class EmployeeSalaryController {
    @Autowired
    private EmployeeSalaryRepo employeeSalaryRepository;

    @Autowired
    private EmployeeRepo employeeRepository;
    // --------------------------------------

    // GET
//    @GetMapping("")
    @GetMapping({"", "/"})
    public String getAll(Model model) {
        List<EmployeeSalary> salaries = employeeSalaryRepository
                .findAll(Sort.by(Sort.Direction.DESC, "id"));
        model.addAttribute("salaries", salaries);
        return "salary/salaries";
    }

    // ADD
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("salaryDTO", new UserDTO());
//        model.addAttribute("employees", employeeRepo.findAll());
        return "salary/salaries-add";
    }
    @PostMapping("/add")
    public String addSalary(@RequestBody EmployeeSalaryDTO models) {
        Employee employee = employeeRepository.findById(models.getEmployeeId()).orElse(null);
        EmployeeSalary salary = new EmployeeSalary();

        salary.setEmployee(employee);
        salary.setEmployeePaymentAmount(models.getAmount());
        salary.setEmployeePaymentMethod(models.getMethod());
        salary.setLastPayment(LocalDate.now());

        employeeSalaryRepository.save(salary);
        return "redirect:/salaries";
    }


    // EDIT


    // DELETE


}
