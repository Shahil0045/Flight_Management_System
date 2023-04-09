package com.FlightManagementSystem.controller;

import com.FlightManagementSystem.entity.Flight;
import com.FlightManagementSystem.entity.Passenger;
import com.FlightManagementSystem.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/* http://localhost:9998/passenger/addPassenger */

/*
{
    "pnrNumber" : "",
    "passengerName" : "",
    "passengerAge" : "",
    "passengerUIN" : "",
    "luggage" : ""
}
*/

@RestController
@RequestMapping(value = "/passenger")
public class PassengerController {

    @Autowired
    private PassengerService passengerService;

    @PostMapping(value = "/addPassenger")
    public ResponseEntity<Passenger> addFlight(@RequestBody Passenger p) {
        return new ResponseEntity<Passenger>(passengerService.addPassenger(p), HttpStatus.CREATED);
    }

}
