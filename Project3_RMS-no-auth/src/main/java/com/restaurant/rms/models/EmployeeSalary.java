package com.restaurant.rms.models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="EmployeeSalary")
public class EmployeeSalary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employeePaymentId;

    private double employeePaymentAmount;
    private String employeePaymentMethod;
    private LocalDate lastPayment;

    @ManyToOne
    @JoinColumn(name="employee_id")
//    @JoinColumn(name="id")
    private Employee employee;

    // Getters and setters
    public int getEmployeePaymentId() {
        return employeePaymentId;
    }

    public void setEmployeePaymentId(int employeePaymentId) {
        this.employeePaymentId = employeePaymentId;
    }

    public double getEmployeePaymentAmount() {
        return employeePaymentAmount;
    }

    public void setEmployeePaymentAmount(double employeePaymentAmount) {
        this.employeePaymentAmount = employeePaymentAmount;
    }

    public String getEmployeePaymentMethod() {
        return employeePaymentMethod;
    }

    public void setEmployeePaymentMethod(String employeePaymentMethod) {
        this.employeePaymentMethod = employeePaymentMethod;
    }

    public LocalDate getLastPayment() {
        return lastPayment;
    }

    public void setLastPayment(LocalDate lastPayment) {
        this.lastPayment = lastPayment;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
