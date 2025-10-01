/*
 * Developer: Ammaar
 * Started: 22.04.25
 * Updated: 05.06.25
*/

package com.restaurant.rms.models;

import jakarta.persistence.*;
import jakarta.persistence.Table;

import java.util.Date;
import java.util.List;

@Entity
//@Table(name="EmployeeTest")
@Table(name="Employee1")
//@Table(name="Employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

//    @Column(columnDefinition = "TEXT")
    private String empFirstName;
    private String empLastName;
    private Date empStartDate;
    private String role;

    private String empContactNum;
    private String empEmail;

    private String empAddress; // ?

    @OneToMany(mappedBy="employee")
    private List<Order> orders;

    @OneToOne(mappedBy = "employee")
    private User user;

    public Employee(){}
    public Employee(String empFirstName, String empLastName, Date date, String role) {
        this.empFirstName = empFirstName;
        this.empLastName = empLastName;
        this.empStartDate = date;
        this.role = role;
    }
    public Employee(
            String empFirstName, String empLastName, Date empStartDate, String role,
            String empContactNum, String empEmail
    ) {
        this.empFirstName = empFirstName;
        this.empLastName = empLastName;
        this.empStartDate = empStartDate;
        this.role = role;
        this.empContactNum = empContactNum;
        this.empEmail = empEmail;
    }
    // -------------------------------------

    // getters
    public int getId() {
        return id;
    }

    public String getEmpFirstName() {
        return empFirstName;
    }

    public String getEmpLastName() {
        return empLastName;
    }

    public Date getEmpStartDate() {
        return empStartDate;
    }

    public String getRole(){
        return role;
    }


    public String getEmpContactNum() {
        return empContactNum;
    }

    public void setEmpContactNum(String empContactNum) {
        this.empContactNum = empContactNum;
    }

    public String getEmpEmail() {
        return empEmail;
    }

    public void setEmpEmail(String empEmail) {
        this.empEmail = empEmail;
    }

    public String getEmpAddress() {
        return empAddress;
    }

    public void setEmpAddress(String empAddress) {
        this.empAddress = empAddress;
    }


    // setters? for updating
    public void setId(int id) {
        this.id = id;
    }

    public void setEmpFirstName(String empFirstName) {
        this.empFirstName = empFirstName;
    }

    public void setEmpLastName(String empLastName) {
        this.empLastName = empLastName;
    }

    public void setEmpStartDate(Date empStartDate) {
        this.empStartDate = empStartDate;
    }

    public void setRole(String role) {
        this.role = role;
    }

    // copying? for updating
    public Employee copy(Employee orignalEmployee){
        return new Employee(
                orignalEmployee.empFirstName,
                orignalEmployee.getEmpLastName(),
                orignalEmployee.getEmpStartDate(),
                orignalEmployee.getRole()
        );
    }

    @Override
    public String toString() {
        return "Employee1{" +
                "empId=" + id +
                ", empFirstName='" + empFirstName + '\'' +
                ", empLastName='" + empLastName + '\'' +
                ", empStartDate=" + empStartDate +
                ", role='" + role + '\'' +
                '}';
    }

}
