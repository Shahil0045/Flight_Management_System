package com.FlightManagementSystem.controller;

import com.FlightManagementSystem.entity.*;
import com.FlightManagementSystem.service.AirportService;
import com.FlightManagementSystem.service.FlightService;
import com.FlightManagementSystem.service.ScheduleFlightServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(value ="/Scheduleflight")
public class ScheduledFlightController {

    @Autowired
    private ScheduleFlightServices scheduleFlightServices;
    @Autowired
    private FlightService flightService;

    List<ScheduleFlightServices> scheduleFlightServicesList;

    @PostMapping(value = "/sF")
    public ResponseEntity<ScheduledFlight> scheduleFlight(@RequestBody ScheduledFlight sf) {
        return  new ResponseEntity<ScheduledFlight>(scheduleFlightServices.scheduleFlight(sf), HttpStatus.CREATED);
    }

    @GetMapping(value = "/vSF/{scheduledFlightId}")
    public ResponseEntity<List<ScheduledFlight>> viewScheduledFlights(@PathVariable int scheduledFlightId) {
        return ResponseEntity.ok(scheduleFlightServices.viewScheduledFlight(scheduledFlightId));
    }

    @GetMapping(value = "/vSFF/{fn}")
    public ResponseEntity<Flight> viewScheduledFlights(@PathVariable Integer fn) {

        return ResponseEntity.ok(scheduleFlightServices.viewScheduledFlights(fn));
    }

    @GetMapping(value = "/viewScheduledFlight")
    public ResponseEntity<List<ScheduledFlight>> viewScheduledFlight() {
        return new  ResponseEntity<List<ScheduledFlight>>(scheduleFlightServices.viewScheduledFlight(),HttpStatus.OK);
    }

    @PostMapping(value = "/mSF")
    public ResponseEntity<ScheduledFlight> modifyScheduledFlight(@RequestBody ScheduledFlight scheduledFlight) {
        ScheduledFlight scheduledFlight1=scheduleFlightServices.modifyScheduledFlight(scheduledFlight);
        return new ResponseEntity<ScheduledFlight>(scheduledFlight, HttpStatus.OK);
    }

    @DeleteMapping(value = "dSF/{scheduledFlightId}")
    public ResponseEntity<String> deleteScheduledFlight(@PathVariable Integer scheduledFlightId) {
        scheduleFlightServices.deleteScheduledFlight(scheduledFlightId);
        return new ResponseEntity<String>("Schedule with flight ID "+scheduledFlightId+" deleted successfully" , HttpStatus.OK);
    }

}
