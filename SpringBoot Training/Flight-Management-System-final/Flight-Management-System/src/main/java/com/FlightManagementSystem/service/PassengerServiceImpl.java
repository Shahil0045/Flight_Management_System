package com.FlightManagementSystem.service;

import com.FlightManagementSystem.entity.Passenger;
import com.FlightManagementSystem.repository.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PassengerServiceImpl implements PassengerService{

    @Autowired
    PassengerRepository passengerRepository;
    @Override
    public Passenger addPassenger(Passenger p) {
        return passengerRepository.save(p);
    }
}
