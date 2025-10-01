//package com.restaurant.rms.controllers;
//
//import com.restaurant.rms.models.DTO.UserDTO;
//import com.restaurant.rms.models.Employee;
//import com.restaurant.rms.models.EmployeeSalary;
//import com.restaurant.rms.models.DTO.EmployeeSalaryDTO;
//import com.restaurant.rms.repository.EmployeeRepo;
//import com.restaurant.rms.repository.EmployeeSalaryRepo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Sort;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//import java.time.LocalDate;
//import java.util.List;
//
//@Controller
////@RequestMapping("/salaries")
//@RequestMapping("/employee-salaries")
//public class EmployeeSalaryController {
//    @Autowired
//    private EmployeeSalaryRepo employeeSalaryRepository;
//
//    @Autowired
//    private EmployeeRepo employeeRepository;
//
//    String entityName = "\n***Employee-salary";
//    // --------------------------------------
//
//    // GET
////    @GetMapping("")
//    @GetMapping({"", "/"})
//    public String getAll(Model model) {
//        System.out.println(entityName);
//        System.out.println("GET. Attempting to get main-page...");
//
//        List<EmployeeSalary> salaries = employeeSalaryRepository
//                .findAll(Sort.by(Sort.Direction.DESC, "employeePaymentId"));
////        List<EmployeeSalary> salaries = employeeSalaryRepository.findAll();
//        model.addAttribute("salaries", salaries);
//        return "salary/salaries";
//    }
//
//    // ADD
//    @GetMapping("/add")
//    public String showAddForm(Model model) {
//        System.out.println(entityName);
//        System.out.println("GET. Attempting to get page to add information...");
//
//        model.addAttribute("salaryDTO", new EmployeeSalaryDTO());
////        model.addAttribute("employees", employeeRepo.findAll());
//        return "salary/salaries-add";
//    }
//    @PostMapping("/add")
//    public String addSalary(@RequestBody EmployeeSalaryDTO models) {
//        System.out.println(entityName);
//        System.out.println("POST. Attempting to add data to the database...");
//
//        Employee employee = employeeRepository.findById(models.getEmployeeId()).orElse(null);
//        EmployeeSalary salary = new EmployeeSalary();
//
//        salary.setEmployee(employee);
//        salary.setEmployeePaymentAmount(models.getAmount());
//        salary.setEmployeePaymentMethod(models.getMethod());
//        salary.setLastPayment(LocalDate.now());
//
//        employeeSalaryRepository.save(salary);
//        return "redirect:/salaries";
//    }
//
//
//    // EDIT
//
//
//    // DELETE
//
//    // --------------------------------------
//
//}

package com.restaurant.rms.controllers;

import com.restaurant.rms.models.DTO.EmployeeDTO;
import com.restaurant.rms.models.Employee;
import com.restaurant.rms.models.EmployeeSalary;
import com.restaurant.rms.models.DTO.EmployeeSalaryDTO;
import com.restaurant.rms.repository.EmployeeRepo;
import com.restaurant.rms.repository.EmployeeSalaryRepo;
import com.restaurant.rms.service.EmployeeSalaryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/employee-salaries")
//@RequestMapping("/salaries")
public class EmployeeSalaryController {

//    private final EmployeeSalaryService salaryService;

    @Autowired
    private final EmployeeRepo employeeRepo;

    @Autowired
    private final EmployeeSalaryRepo salaryRepo;

    @Autowired
    public EmployeeSalaryController(
            EmployeeRepo employeeRepo,
            EmployeeSalaryRepo salaryRepo
    ) {
        this.employeeRepo = employeeRepo;
        this.salaryRepo = salaryRepo;
    }

//    public EmployeeSalaryController(
//            EmployeeSalaryService salaryService,
//            EmployeeRepo employeeRepo,
//            EmployeeSalaryRepo salaryRepo
//    ) {
//        this.salaryService = salaryService;
//        this.employeeRepo = employeeRepo;
//        this.salaryRepo = salaryRepo;
//    }
    // -------------------------------------

    // LIST
    @GetMapping({"", "/"})
    public String list(Model model) {
        System.out.println("Employee-salary, get all");
        List<EmployeeSalary> salaries = salaryRepo.findAll(Sort.by(Sort.Direction.DESC, "employeePaymentId"));
        for (EmployeeSalary e : salaries){
            System.out.println("-" + e);
        }

        model.addAttribute("salaries", salaries);
        return "salary/salaries";
    }

    // SHOW ADD FORM
    @GetMapping("/add")
    public String showAddForm(Model model) {
        System.out.println("Employee-salary, add page. get");

        model.addAttribute("salaryDTO", new EmployeeSalaryDTO());
//        model.addAttribute("employees", employeeRepo.findAll(Sort.by(Sort.Direction.DESC, "id")));
        return "salary/salaries-add";
    }

    // HANDLE ADD POST (form)
    @PostMapping("/add")
    public String add(
            @Valid @ModelAttribute("salaryDTO") EmployeeSalaryDTO dto,
            BindingResult bindingResult,
            Model model
    ) {

        System.out.println("\nEmployee-salary, add page. post");

        if (bindingResult.hasErrors()) {
            model.addAttribute("employees", employeeRepo.findAll(Sort.by(Sort.Direction.DESC, "id")));
            return "salary/salaries-add";
        }


        Employee employee = new Employee(
                "first_name",
                "last_name",
                new Date(),
                "manager"
        );
//        EmployeeRepo employeeRepo;
        System.out.println("Employee: " + employee);
        employeeRepo.save(employee);

//        EmployeeSalary salary = new EmployeeSalary(
//                dto.getAmount(),
//                dto.getMethod(),
//                dto.getLastPayment()
//        );
        EmployeeSalary salary = new EmployeeSalary(
                dto.getAmount(),
                dto.getMethod(),
                dto.getLastPayment(),
                employee
        );

        System.out.println("\nRecord: " + salary);

//        salaryService.createFromDto(dto);
//        salaryService.add(salary);
        salaryRepo.save(salary);

        return "redirect:/employee-salaries";
    }

    // SHOW EDIT FORM
//    @GetMapping("/edit/{id}")
//    @GetMapping("/edit")
//    public String showEditPage(@PathVariable("id") int id, Model model) {
//        System.out.println("Employee-salary, edit page. get");
//
////        Optional<EmployeeSalary> opt = salaryService.getById(id);
//
//        Optional<EmployeeSalary> opt = salaryRepo.findById(id);
//
//        if (opt.isEmpty()) return "redirect:/salaries";
//
//        EmployeeSalary salary = opt.get();
//        EmployeeSalaryDTO dto = new EmployeeSalaryDTO();
//        dto.setEmployeePaymentId(salary.getEmployeePaymentId());
//        dto.setEmployeeId(salary.getEmployee() != null ? salary.getEmployee().getId() : null);
//        dto.setAmount(salary.getEmployeePaymentAmount());
//        dto.setMethod(salary.getEmployeePaymentMethod());
//        dto.setLastPayment(salary.getLastPayment());
//
//        model.addAttribute("salaryDTO", dto);
//        model.addAttribute("employees", employeeRepo.findAll(Sort.by(Sort.Direction.DESC, "id")));
//        return "salary/salaries-edit";
//    }


@GetMapping("/edit")
public String showEditPage(
        Model model,
        @RequestParam int id
) {
    System.out.println("\n*** Salaries(EDIT) Getting...");
    try {
        EmployeeSalary employeeSalary = salaryRepo.findById(id).get();
        EmployeeSalaryDTO salaryDTO = new EmployeeSalaryDTO();

        System.out.println("\nUpdate. employee-salary");
        System.out.println(employeeSalary);

        salaryDTO.setAmount(employeeSalary.getEmployeePaymentAmount());
        salaryDTO.setMethod(employeeSalary.getEmployeePaymentMethod());
        salaryDTO.setLastPayment(employeeSalary.getLastPayment());

        System.out.println("\nDTO: \n" + salaryDTO);

        model.addAttribute("employeeSalary", employeeSalary);
        model.addAttribute("DTO", salaryDTO);
    }
    catch (Exception ex) {
        System.out.println("Exception" + ex.getMessage());
        return "redirect:/employee-salaries";
    }
    return "salary/salaries-edit";
}

    @PostMapping("/edit")
    public String editRecord(
            Model model,
            @RequestParam int id,
            @Valid @ModelAttribute("salaryDTO") EmployeeSalaryDTO employeeSalaryDTO,
            BindingResult bindingResult
    ) {
        System.out.println("\n***Employee salary (EDIT) Putting...");


        try {
            EmployeeSalary employeeSalary = salaryRepo.findById(id).get();
//            EmployeeSalary employeeSalary = salaryRepo.findById(id).orElse(null);
            model.addAttribute("employeeSalaryDTO", employeeSalary);

            if (bindingResult.hasErrors()) {
                return "salary/salaries-edit";
            }

            // updating other details
            employeeSalary.setEmployeePaymentMethod(employeeSalaryDTO.getMethod());
            employeeSalary.setEmployeePaymentAmount(employeeSalaryDTO.getAmount());

            salaryRepo.save(employeeSalary);
            System.out.println("\n***Updated employee-salary successfully");
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return "redirect:/employee-salaries";

//        if (bindingResult.hasErrors()) {
//            model.addAttribute("employees", employeeRepo.findAll(Sort.by(Sort.Direction.DESC, "id")));
//            return "salary/salaries-edit";
//        }
//
//        salaryRepo.save(dto);
////        salaryService.updateFromDto(dto);
//        return "redirect:/employee-salaries";
    }

    // DELETE
    @GetMapping("/delete")
    public String deleteEmployee(@RequestParam int id) {
        try {
            salaryRepo.deleteById(id);
            // or
            EmployeeSalary employeeSalary = salaryRepo.findById(id).get();

            // delete from database
            salaryRepo.delete(employeeSalary);
            System.out.println("\n***Successful deletion of:");
            System.out.println(employeeSalary);
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return "redirect:/employee-salaries";
    }

    // DELETE
//    @GetMapping("/delete")
////    @GetMapping("/delete/{id}")
//    public String delete(@PathVariable("id") int id) {
//        salaryRepo.deleteById(id);
////        salaryService.delete(id);
//        return "redirect:/salaries";
//    }
}
