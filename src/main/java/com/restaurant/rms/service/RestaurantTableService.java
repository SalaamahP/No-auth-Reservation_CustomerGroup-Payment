package com.restaurant.rms.service;

import com.restaurant.rms.models.RestaurantTable;
import com.restaurant.rms.repository.RestaurantTableRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantTableService {
    @Autowired
    RestaurantTableRepo repo;

    public RestaurantTableService(RestaurantTableRepo tableRepo){
        this.repo = tableRepo;
    }
    // ----------------------------------

    public RestaurantTable add(RestaurantTable table){
        return repo.save(table);
    }

    public RestaurantTable read(int id){
        return repo.findById(id).orElse(null);
    }
    public List<RestaurantTable> getAll(){
        return repo.findAll();
    }

    public RestaurantTable update(RestaurantTable table){
        return repo.save(table);
    }

    public boolean delete(int id){
        repo.deleteById(id);
        return true;
    }
}
