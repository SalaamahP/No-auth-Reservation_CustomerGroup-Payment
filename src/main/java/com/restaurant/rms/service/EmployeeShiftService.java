package com.restaurant.rms.service;


import com.restaurant.rms.models.EmployeeShift;
import com.restaurant.rms.repository.EmployeeShiftRepo;
//import com.restaurant.rms.repository.OrderRepo;
//import models.EmployeeShift;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import services.repository.EmployeeShiftRepo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeShiftService{

    @Autowired
    EmployeeShiftRepo shiftRepository;

//    @Autowired
//    OrderRepo repo;

    public EmployeeShiftService(EmployeeShiftRepo orderRepo){
        this.shiftRepository = orderRepo;
    }
    // -------------------------------

//    @Override
    public EmployeeShift create(EmployeeShift shift) {
        return shiftRepository.save(shift);
    }

//    @Override
    public EmployeeShift read(EmployeeShift shift){
        Integer id = shift.getId();
        return shiftRepository.findById(id).orElse(null);
    }

//    @Override
    public EmployeeShift update(EmployeeShift expenses) {
        return shiftRepository.save(expenses);
    }

//    @Override
    public void delete(Integer id) {
        shiftRepository.deleteById(id);
    }


//    EmployeeShiftServices(EmployeeShiftRepo shiftRepository) {
//        this.shiftRepository = shiftRepository;
//    }

//    @Override
    public List<EmployeeShift> getAll(EmployeeShift shift) {
        return shiftRepository.findAll();
    }

    public List<EmployeeShift> filterShifts(int id, LocalDateTime startTime,
                                            LocalDateTime endTime) {

        List<EmployeeShift> result = new ArrayList<>();

        for (EmployeeShift shift : shiftRepository.findAll()) {
            boolean matches = true;

            if (id != 0 && shift.getId() != id) {
                matches = false;
            }

            if (startTime != null && !shift.getStartTime().equals(startTime)) {
                matches = false;
            }

            if (endTime != null && !shift.getEndTime().equals(endTime)) {
                matches = false;
            }

            if (matches) {
                result.add(shift);
            }
        }

        return result;
    }

}