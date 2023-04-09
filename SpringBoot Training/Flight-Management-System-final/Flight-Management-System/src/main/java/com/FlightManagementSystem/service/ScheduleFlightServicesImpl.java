package com.FlightManagementSystem.service;

import com.FlightManagementSystem.entity.*;
import com.FlightManagementSystem.exception.ScheduleFlightNotFoundException;
import com.FlightManagementSystem.repository.AirportRepository;
import com.FlightManagementSystem.repository.FlightRepository;
import com.FlightManagementSystem.repository.ScheduleFlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class ScheduleFlightServicesImpl implements ScheduleFlightServices {

    @Autowired
    private ScheduleFlightRepository scheduledFlightRepository;

    @Autowired
    private FlightRepository flightRepository;

    @Override
    public ScheduledFlight scheduleFlight(ScheduledFlight scheduledFlight) {

        if (scheduledFlightRepository.existsById(scheduledFlight.getScheduledFlightId())) {
            throw new ScheduleFlightNotFoundException("Scheduled Flight Already EXits");
        }
        return scheduledFlightRepository.save(scheduledFlight);
    }

    @Override
    public List<ScheduledFlight> viewScheduledFlight(Integer scheduledFlightId) {
        if (!scheduledFlightRepository.existsById(scheduledFlightId)) {
            throw new ScheduleFlightNotFoundException("Scheduled Flight not found");
        }
        return scheduledFlightRepository.findAllById(Collections.singleton(scheduledFlightId));

    }

    @Override
    public Flight viewScheduledFlights(Integer fn) {

        Optional<Flight> op = flightRepository.findById(fn);
        Flight flight = op.get();
        return flight;
    }

    @Override
    public List<ScheduledFlight> viewScheduledFlight() {
        return scheduledFlightRepository.findAll();
    }

    @Override
    public ScheduledFlight modifyScheduledFlight(ScheduledFlight scheduledFlight) {

        if (!scheduledFlightRepository.existsById(scheduledFlight.getScheduledFlightId())) {
            throw new ScheduleFlightNotFoundException("Scheduled Flight not found for modifying");
        }
        Optional<ScheduledFlight> findbyid = scheduledFlightRepository.findById(scheduledFlight. getScheduledFlightId());
        if (findbyid.isPresent()) {
            scheduledFlightRepository.save(scheduledFlight);
        }
        return scheduledFlight;
    }


    @Override
    public void deleteScheduledFlight(Integer scheduledFlightId) {
        if (!scheduledFlightRepository.existsById(scheduledFlightId)) {
            throw new ScheduleFlightNotFoundException("Scheduled Flight not found");
        }
        scheduledFlightRepository.deleteById(scheduledFlightId);
    }

}