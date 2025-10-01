package com.restaurant.rms.service;

import com.restaurant.rms.models.Order;
import com.restaurant.rms.repository.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    OrderRepo repo;

    public OrderService(OrderRepo orderRepo){
        this.repo = orderRepo;
    }
    // -----------------------------------

    public Order add(Order order){
        return repo.save(order);
    }

    public Order get(int id){
        return repo.findById(id).orElse(null);
    }
    public List<Order> getAll(){
        return repo.findAll();
    }

    public Order update(Order order){
        return repo.save(order);
    }

    public boolean delete(int id){
        repo.deleteById(id);
        return true;
    }
}
