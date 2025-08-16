package com.restaurant.rms.models;

import jakarta.persistence.*;


@Entity
@Table(name="Expense")
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String expenseName;
    private String expenseDate;
    private Double expenseAmount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getExpenseName() {
        return expenseName;
    }

    public void setExpenseName(String name) {
        this.expenseName = expenseName;
    }

    public String getExpenseDate() {
        return expenseDate;
    }

    public void setExpenseDate(String category) {
        this.expenseDate = expenseDate;
    }

    public Double getExpenseAmount() {
        return expenseAmount;
    }

    public void setExpenseAmount(Double expenseAmount) {
        this.expenseAmount = expenseAmount;
    }
}
