package com.restaurant.rms.service;

import com.restaurant.rms.models.Reservation;
import com.restaurant.rms.models.ReservationId;
import com.restaurant.rms.repository.ReservationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {
    @Autowired
    ReservationRepo repository;

    public ReservationService(ReservationRepo repository) {
        this.repository = repository;
    }

    public Reservation add(Reservation reservation) {
        return repository.save(reservation);
    }

    public Reservation read(ReservationId id) {
        return repository.findById(id).orElse(null);
    }

    public List<Reservation> getAll() {
        return repository.findAll();
    }

    public Reservation update(Reservation reservation) {
        return repository.save(reservation);
    }

    public boolean delete(ReservationId id) {
        repository.deleteById(id);
        return true;
    }
}
