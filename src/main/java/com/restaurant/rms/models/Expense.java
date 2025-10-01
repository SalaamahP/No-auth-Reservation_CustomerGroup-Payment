package com.restaurant.rms.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;


@Entity
@Table(name="Expense")
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String expenseName;
//    private String expenseDate;
    private LocalDateTime expenseDate;
    private Double expenseAmount;

    @ManyToOne
    @JoinColumn(name="employee_id")
    private Employee employee;

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

    public LocalDateTime getExpenseDate() {
        return expenseDate;
    }

    public void setExpenseDate(LocalDateTime category) {
        this.expenseDate = expenseDate;
    }

    public Double getExpenseAmount() {
        return expenseAmount;
    }

    public void setExpenseAmount(Double expenseAmount) {
        this.expenseAmount = expenseAmount;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "id=" + id +
                ", expenseName='" + expenseName + '\'' +
                ", expenseDate='" + expenseDate + '\'' +
                ", expenseAmount=" + expenseAmount +
                '}';
    }
}
