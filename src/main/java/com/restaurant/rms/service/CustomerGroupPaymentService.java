package com.restaurant.rms.service;

import com.restaurant.rms.models.CustomerGroupPayment;
import com.restaurant.rms.repository.CustomerGroupPaymentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerGroupPaymentService {
    @Autowired
    CustomerGroupPaymentRepo repository;

    public CustomerGroupPaymentService(CustomerGroupPaymentRepo customerGroupPaymentRepo){
        this.repository = customerGroupPaymentRepo;
    }
    public CustomerGroupPayment add (CustomerGroupPayment customerGroupPayment){
        return repository.save(customerGroupPayment);
    }
    public CustomerGroupPayment read (int id){
        return repository.findById(id).orElse(null);
    }
    public List<CustomerGroupPayment> getAll(){
        return repository.findAll();
    }
    public CustomerGroupPayment update (CustomerGroupPayment customerGroupPayment){
        return repository.save(customerGroupPayment);
    }
    public boolean delete (int id){
        repository.deleteById(id);
        return true;
    }
}
