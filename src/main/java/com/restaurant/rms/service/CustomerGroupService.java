package com.restaurant.rms.service;

import com.restaurant.rms.models.CustomerGroup;
import com.restaurant.rms.models.CustomerGroupPayment;
import com.restaurant.rms.repository.CustomerGroupPaymentRepo;
import com.restaurant.rms.repository.CustomerGroupRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerGroupService {
    @Autowired
    CustomerGroupRepo customerGroupRepo;

    public CustomerGroupService(CustomerGroupRepo customerGroupRepo) {
        this.customerGroupRepo = customerGroupRepo;
    }

    public CustomerGroup add(CustomerGroup customerGroup) {
        return customerGroupRepo.save(customerGroup);
    }

    public CustomerGroup read(int id) {
        return customerGroupRepo.findById(id).orElse(null);

    }

    public List<CustomerGroup> getAll() {
        return customerGroupRepo.findAll();
    }

    public CustomerGroup update(CustomerGroup customerGroup) {
        return customerGroupRepo.save(customerGroup);
    }

    public boolean delete(int id) {
        customerGroupRepo.deleteById(id);
        return true;
    }
}
