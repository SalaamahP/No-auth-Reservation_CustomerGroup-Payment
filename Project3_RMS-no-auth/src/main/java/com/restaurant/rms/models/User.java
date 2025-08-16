package com.restaurant.rms.models;

import jakarta.persistence.*;

@Entity
@Table(name="User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
//    private Integer id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String role;



//    @ManyToOne
//    @JoinColumn(name = "employee_id", nullable = false)
//    private Employee employee;

    public User(){}
    public User(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }
//    public User(String username, String password, String role, Employee employee) {
//        this.username = username;
//        this.password = password;
//        this.role = role;
////        this.employee = employee;
//    }

    // Getters and setters
    public Integer getUserId() { return userId; }
    public void setUserId(Integer userId) { this.userId = userId; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

//    public Employee getEmployee() { return employee; }
//    public void setEmployee(Employee employee) { this.employee = employee; }
}
