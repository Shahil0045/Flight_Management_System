package com.FlightManagementSystem.service;

import com.FlightManagementSystem.entity.Airport;
import com.FlightManagementSystem.entity.User;
import com.FlightManagementSystem.exception.AirportNotFoundException;
import com.FlightManagementSystem.exception.ScheduleFlightNotFoundException;
import com.FlightManagementSystem.exception.UserNotFoundException;
import com.FlightManagementSystem.repository.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AirportServiceImpl implements AirportService{

    @Autowired
    private AirportRepository airportRepository;

    @Override
    public Airport addAirport(Airport airport) {
        if (airportRepository.existsById(airport.getAirportCode())) {
            throw new AirportNotFoundException("Cannot have same airport code:Already Exits");
        }
        return airportRepository.save(airport);
    }

    @Override
    public List<Airport> viewAirport() {
        return airportRepository.findAll();
    }

    @Override
    public Airport viewAirport(String va) {
        Optional<Airport> opt = airportRepository.findById(va);
        return opt.orElseThrow(()->new AirportNotFoundException("Airport with given code  "+ va +" is not exists!"));

    }

}