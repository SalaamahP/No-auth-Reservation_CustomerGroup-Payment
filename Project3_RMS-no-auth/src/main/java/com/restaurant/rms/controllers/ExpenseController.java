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

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/expenses")
public class ExpenseController {

    @Autowired
    private ExpenseRepo ExpensesRepo;

    // READ
//    @GetMapping({"", "/"})
    @GetMapping("")
    public String showExpenses(Model model) {
        List<Expense> expenses = ExpensesRepo.findAll();
        model.addAttribute("Expenses", expenses);
        return "expense/expenses";
    }

    // ADD
    @GetMapping("/add")
    public String showCreatePage(Model model) {
        ExpenseDTO expensesDTO = new ExpenseDTO();
        model.addAttribute("ExpensesDTO", expensesDTO);
        return "expense/expenses-add";
    }
//    @PostMapping("/add")
//    public String createExpense(
//            @Valid @ModelAttribute ExpenseDTO expensesDTO,
//            BindingResult result
//    ) {
//        if (result.hasErrors()) {
//            return "Expenses/createExpense";
//        }
//
//        Date date = new Date();
//        // Create Expense
//
//        Expense Expense = new Expense();
//        Expense.setExpenseName(expensesDTO.getExpenseName());
//        Expense.setExpenseDate(date.toString());
//        Expense.setExpenseAmount(expensesDTO.getExpenseAmount());
//
//        ExpensesRepo.save(Expense);
//
//        return "redirect:/Expenses";
//    }

    // UPDATE
    @GetMapping("/edit")
    public String showEditPage(Model model, @RequestParam int id) {
        try {
            Expense Expense = ExpensesRepo.findById(id).get();
            model.addAttribute("Expense", Expense);

            Date date = new Date();
            ExpenseDTO expenseDTO = new ExpenseDTO();

            Expense.setExpenseName(expenseDTO.getExpenseName());
            Expense.setExpenseDate(date.toString());
            Expense.setExpenseAmount(expenseDTO.getExpenseAmount());

            model.addAttribute("expenseDTO", expenseDTO);
            return "Expenses/editExpense";
        }
        catch (Exception ex) {
            System.out.println("Exception: " + ex.getMessage());
            return "redirect:/Expenses";

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
        try {
            Expense Expense = ExpensesRepo.findById(id).get();
            model.addAttribute("Expense", Expense);

            if (result.hasErrors()) {
                return "Expenses/editExpense";
            }
            Expense.setExpenseName(expenseDTO.getExpenseName());
            Expense.setExpenseAmount(expenseDTO.getExpenseAmount());

            ExpensesRepo.save(Expense);
        }
        catch (Exception ex) {
            System.out.println("Exception: " + ex.getMessage());
        }
        return "redirect:/Expenses";
    }

    // DELETE
    // Delete expenses?
}
