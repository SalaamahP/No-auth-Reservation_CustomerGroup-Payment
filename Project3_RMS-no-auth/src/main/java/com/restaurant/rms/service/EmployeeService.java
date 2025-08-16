package com.restaurant.rms.service;

import com.restaurant.rms.models.Employee;
import com.restaurant.rms.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepo repo;

    public EmployeeService(EmployeeRepo employeeRepo){
        this.repo = employeeRepo;
    }
    // ----------------------------------

    public Employee add(Employee employee){
        return repo.save(employee);
    }

    public Employee read(int id){
        return repo.findById(id).orElse(null);
    }
    public List<Employee> getAll(){
        return repo.findAll();
    }

    public Employee update(Employee employee){
        return repo.save(employee);
    }

    public boolean delete(int id){
        repo.deleteById(id);
        return true;
    }
}
