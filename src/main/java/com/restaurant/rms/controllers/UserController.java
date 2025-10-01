package com.restaurant.rms.controllers;

import com.restaurant.rms.models.DTO.EmployeeDTO;
import com.restaurant.rms.models.DTO.UserDTO;
import com.restaurant.rms.models.User;
import com.restaurant.rms.repository.EmployeeRepo;
import com.restaurant.rms.repository.UserRepo;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private EmployeeRepo employeeRepo;

    String entityName = "\n***User";
    // -------------------------------------

    // GET
    // List all users
//    @GetMapping("")
    @GetMapping({"", "/"})
    public String listUsers(Model model) {
        System.out.println(entityName);
        System.out.println("GET. Attempting to get main-page...");

        model.addAttribute("users", userRepo.findAll());
        return "user/users";
    }

//    @GetMapping("/add")
//    public String showAddPage(Model model) {
//        EmployeeDTO empDTO = new EmployeeDTO();
//        model.addAttribute("employeeDTO", empDTO);
//        return "employee/employees-add";
//    }
    // ADD
    // Show add form
    @GetMapping("/add")
    public String showAddForm(Model model) {
        System.out.println(entityName);
        System.out.println("GET. Attempting to get add-page...");

        model.addAttribute("userDTO", new UserDTO());
//        model.addAttribute("employees", employeeRepo.findAll());
        return "user/users-add";
    }
    // Save new user
    @PostMapping("/add")
    public String saveUser(
            @Valid @ModelAttribute("userDTO") UserDTO userDTO,
            BindingResult result,
            Model model
    ) {
        System.out.println(entityName);
        System.out.println("POST. Attempting to add data to the database...");

//        if (result.hasErrors()) {
//            model.addAttribute("employees", employeeRepo.findAll());
//            return "user/users-add";
//        }
//        var emp = employeeRepo.findById(userDTO.getEmployeeId());
//        if (emp.isEmpty()) {
//            result.rejectValue("employeeId", "NotFound", "Employee not found");
//            model.addAttribute("employees", employeeRepo.findAll());
//            return "user/users-add";
//        }
        User user = new User(
                userDTO.getUsername(),
                userDTO.getPassword(),
                userDTO.getRole()
//                emp.get()
        );
        userRepo.save(user);
        return "redirect:/users";
    }

    // EDIT
    // Show edit form
//    @GetMapping("/edit/{id}")
    @GetMapping("/edit")
    public String showEditForm(
            @PathVariable("id") Integer id,
            Model model
    ) {
        System.out.println(entityName);
        System.out.println("GET. Attempting to get edit-page...");

        var opt = userRepo.findById(id);
        if (opt.isEmpty()) {
            return "redirect:/users";
        }
        User u = opt.get();
        UserDTO dto = new UserDTO();
        dto.setUserId(u.getUserId());
        dto.setUsername(u.getUsername());
        dto.setPassword(u.getPassword());
        dto.setRole(u.getRole());
//        dto.setEmployeeId(u.getEmployee().getId());

        model.addAttribute("userDTO", dto);
//        model.addAttribute("employees", employeeRepo.findAll());
        return "user/users-edit";
    }
    // Update user
//    @RequestParam int id,
    @PostMapping("/edit")
    public String updateUser(
            @Valid @ModelAttribute("userDTO") UserDTO userDTO,
            BindingResult result,
            Model model
    ) {
        System.out.println(entityName);
        System.out.println("POST. Attempting to add updated data to the database...");

        if (result.hasErrors()) {
            model.addAttribute("employees", employeeRepo.findAll());
            return "user/users-edit";
        }
        var opt = userRepo.findById(userDTO.getUserId());
        var empOpt = employeeRepo.findById(userDTO.getEmployeeId());
        if (opt.isEmpty() || empOpt.isEmpty()) {
            return "redirect:/users";
        }
        User user = opt.get();
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        user.setRole(userDTO.getRole());
//        user.setEmployee(empOpt.get());

        userRepo.save(user);
        return "redirect:/users";
    }

    // DELETE
//    @GetMapping("/delete/{id}")
    @GetMapping("/delete")
    public String deleteUser(@PathVariable("id") Integer id) {
        System.out.println(entityName);
        System.out.println("GET. Attempting to delete data from the database...");

        userRepo.deleteById(id);
        return "redirect:/users";
    }
}
