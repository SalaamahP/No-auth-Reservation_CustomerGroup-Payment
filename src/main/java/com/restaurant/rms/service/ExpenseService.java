package com.restaurant.rms.service;

import com.restaurant.rms.models.Expense;
import com.restaurant.rms.repository.ExpenseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService {

    @Autowired
    ExpenseRepo expenseRepository;

    ExpenseService(ExpenseRepo expenseRepository) {
        this.expenseRepository = expenseRepository;
    }
    // -----------------------------------

    public Expense create(Expense expenses) {
        return expenseRepository.save(expenses);
    }

    public Expense read(Expense expenses){
        Integer id = expenses.getId();
        return expenseRepository.findById(id).orElse(null);
    }

    public Expense update(Expense expenses) {
        return expenseRepository.save(expenses);
    }

    public void delete(Integer id) {
        expenseRepository.deleteById(id);
    }

    public List<Expense> getAll(Expense expenses) {
        return expenseRepository.findAll();
    }


//    public Double calculateTotal(ExpensesRepo expenseRepository) {
//        Double total = 0.00;
//        for (Expenses expense : expenseRepository.findAll()) {
//            if (expense.getExpenseAmount() != null) {
//                total= total + expense.getExpenseAmount();
//            }
//        }
//        return total;
//    }
}
