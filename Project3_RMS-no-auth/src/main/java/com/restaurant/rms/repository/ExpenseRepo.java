package com.restaurant.rms.repository;

import com.restaurant.rms.models.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepo extends JpaRepository<Expense, Integer>{
}
