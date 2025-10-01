package com.restaurant.rms.service;

import com.restaurant.rms.models.EmployeeSalary;
import com.restaurant.rms.repository.EmployeeSalaryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeSalaryService {

    @Autowired
    private EmployeeSalaryRepo repo;

    public EmployeeSalaryService(EmployeeSalaryRepo employeeSalaryRepo) {
        this.repo = employeeSalaryRepo;
    }
    // ----------------------------------

    public EmployeeSalary add(EmployeeSalary employeeSalary) {
        return repo.save(employeeSalary);
    }

    public EmployeeSalary read(int id) {
        return repo.findById(id).orElse(null);
    }

    public List<EmployeeSalary> getAll() {
        return repo.findAll();
    }

    public EmployeeSalary update(EmployeeSalary employeeSalary) {
        return repo.save(employeeSalary);
    }

    public boolean delete(int id) {
        repo.deleteById(id);
        return true;
    }
}
