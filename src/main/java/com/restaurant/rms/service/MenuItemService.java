package com.restaurant.rms.service;

import com.restaurant.rms.models.MenuItem;
import com.restaurant.rms.repository.MenuItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuItemService {
    @Autowired
    MenuItemRepo repo;

    public MenuItemService(MenuItemRepo menuItemRepo){
        this.repo = menuItemRepo;
    }
    // ----------------------------------

    public MenuItem add(MenuItem menuItem){
        return repo.save(menuItem);
    }

    public MenuItem read(int id){
        return repo.findById(id).orElse(null);
    }
    public List<MenuItem> getAll(){
        return repo.findAll();
    }

    public MenuItem update(MenuItem menuItem){
        return repo.save(menuItem);
    }

    public boolean delete(int id){
        repo.deleteById(id);
        return true;
    }
}
