package com.FlightManagementSystem.service;
import com.FlightManagementSystem.entity.Flight;
import com.FlightManagementSystem.exception.FlightNotFoundException;

import com.FlightManagementSystem.repository.FlightRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class FlightServiceImpl implements FlightService{

    @Autowired
    FlightRepository flightRepository;
    @Override
    public Flight addFlight(Flight flight) {
        if (flightRepository.existsById(flight.getFlightNumber())) {
            throw new FlightNotFoundException("Cannot have same flight number :Already Exits!" );
        }

        return flightRepository.save(flight) ;
    }

    @Override
    public Flight modifyFlight(Flight flight) {
        if(!flightRepository.existsById(flight.getFlightNumber())) {
            throw new FlightNotFoundException("Flight with this : " + flight.getFlightNumber() + " number is Not available for modifying");
        }
        Optional<Flight> findbyid = flightRepository.findById(flight.getFlightNumber());
        if (findbyid.isPresent()) {
            flightRepository.save(flight);
        }
        return flight;
    }

    @Override
    public List<Flight> viewFlight(Integer fid) {
        if (!flightRepository.existsById(fid)) {
            throw new FlightNotFoundException("Flight with this " + fid  + " Not Found");
        }

        return  flightRepository.findAllById(Collections.singleton(fid));
    }

    @Override
    public List<Flight> viewFlight() {

        return flightRepository.findAll();
    }

    @Override
    public void deleteFlight(Integer id) {
        if (!flightRepository.existsById(id)) {
            throw new FlightNotFoundException("Flight with this " + id  + " Not Found");
        }

        flightRepository.deleteById(id);
    }

}
