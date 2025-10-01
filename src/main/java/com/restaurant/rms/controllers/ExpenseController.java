package com.restaurant.rms.controllers;

import com.restaurant.rms.models.DTO.ExpenseDTO;
import com.restaurant.rms.models.Expense;
import com.restaurant.rms.repository.ExpenseRepo;
import jakarta.validation.Valid;
//import models.Expense;
//import models.DTO.ExpenseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
//import services.ExpensesRepo;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/expenses")
public class ExpenseController {
    @Autowired
    private ExpenseRepo ExpensesRepo;
    // -----------------------------

    // READ
//    @GetMapping({"", "/"})
    @GetMapping("")
    public String showExpenses(Model model) {
        System.out.println("\nEmployee-expense. get all");

        List<Expense> expenses = ExpensesRepo.findAll();

        for(Expense e : expenses){
            System.out.println("- " + e);
        }

        model.addAttribute("Expenses", expenses);
        return "expense/expenses";
    }

    // ADD
    @GetMapping("/add")
    public String showCreatePage(Model model) {
        System.out.println("Employee-expense. add page. get");

        ExpenseDTO expenseDTO = new ExpenseDTO();
        model.addAttribute("expenseDTO", expenseDTO);
        return "expense/expenses-add";
    }
    @PostMapping("/add")
    public String createExpense(
            @Valid @ModelAttribute ExpenseDTO expensesDTO,
            BindingResult result
    ) {
        System.out.println("Employee-expense. add page. post");

        if (result.hasErrors()) {
            return "expense/expenses-add";
//            return "Expenses/createExpense";
        }

//        Date date = new Date();
        Expense Expense = new Expense();
        Expense.setExpenseName(expensesDTO.getExpenseName());
//        Expense.setExpenseDate(date.toString());
        Expense.setExpenseDate(LocalDateTime.now());
        Expense.setExpenseAmount(expensesDTO.getExpenseAmount());

        System.out.println("\nRecord:");
        System.out.println(Expense);
        ExpensesRepo.save(Expense);
        return "redirect:/expenses";
    }

    // UPDATE
    @GetMapping("/edit")
    public String showEditPage(Model model, @RequestParam int id) {
        System.out.println("Employee-expense. edit page. get");

        try {
            Expense Expense = ExpensesRepo.findById(id).get();

            Date date = new Date();
            ExpenseDTO expenseDTO = new ExpenseDTO();

            Expense.setExpenseName(expenseDTO.getExpenseName());
//            Expense.setExpenseDate(LocalDateTime.now());
//            Expense.setExpenseDate(date.toString());
            Expense.setExpenseAmount(expenseDTO.getExpenseAmount());
            Expense.setExpenseDate(expenseDTO.getExpenseDate());

            model.addAttribute("Expense", Expense);
            model.addAttribute("expenseDTO", expenseDTO);
            return "expense/expenses-edit";
        }
        catch (Exception ex) {
            System.out.println("Exception: " + ex.getMessage());
            return "redirect:/expenses";
//            return "redirect:/Expenses";

        }
    }
    @PostMapping("/edit")
    public String updateExpense(
            Model model,
            @RequestParam int id,
            @Valid @ModelAttribute
            ExpenseDTO expenseDTO,
            BindingResult result
    ) {
        System.out.println("Employee-expense. edit page. post");

        try {
            Expense expense = ExpensesRepo.findById(id).get();
            model.addAttribute("Expense", expense);

            if (result.hasErrors()) {
                return "expense/expenses-edit";
            }
            expense.setExpenseName(expenseDTO.getExpenseName());
            expense.setExpenseAmount(expenseDTO.getExpenseAmount());
            expense.setExpenseDate(expenseDTO.getExpenseDate());

            System.out.println("\n***updated (expense)");
            System.out.println(expense);
            ExpensesRepo.save(expense);
        }
        catch (Exception ex) {
            System.out.println("Exception: " + ex.getMessage());
        }
        return "redirect:/expenses";
//        return "redirect:/Expenses";
    }
}
