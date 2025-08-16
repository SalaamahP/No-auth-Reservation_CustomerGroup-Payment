package com.restaurant.rms.repository;

import com.restaurant.rms.models.EmployeeSalary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeSalaryRepo extends JpaRepository<EmployeeSalary, Integer> {
//public interface EmployeeSalaryRepo extends JpaRepository<EmployeeSalary, Long> {
}
