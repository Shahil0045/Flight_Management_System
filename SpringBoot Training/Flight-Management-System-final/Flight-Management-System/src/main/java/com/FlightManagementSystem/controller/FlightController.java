package com.FlightManagementSystem.controller;

import com.FlightManagementSystem.entity.Flight;
import com.FlightManagementSystem.service.FlightService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping(value ="/flight")
public class FlightController {

    @Autowired
    FlightService flightService;

     List<Flight>  flightList;

    @PostMapping(value = "/addFlight")
    public ResponseEntity<Flight> addFlight(@RequestBody Flight af) {
        return new ResponseEntity<Flight>(flightService.addFlight(af), HttpStatus.CREATED);
    }

    @PutMapping("/modifyFlight")
    public ResponseEntity<Flight> modifyFlight(@Valid @RequestBody Flight flight) {
        Flight newFlight = flightService.modifyFlight(flight);
        return new ResponseEntity<Flight>(flight, HttpStatus.OK);
    }

    @GetMapping(value = "/viewFlight/{flight}")
    public ResponseEntity<List<Flight>> viewFlight(@PathVariable(name="flight") Integer flightno) {
        return ResponseEntity.ok(flightService.viewFlight(flightno));
    }

    @GetMapping(value = "/viewFlight")
    public ResponseEntity<List<Flight>> viewFlight() {

        return new ResponseEntity<List<Flight>>(flightService.viewFlight(),HttpStatus.OK);
    }

    @DeleteMapping(value = "/deleteFlight/{id}")
    public ResponseEntity<String> deleteFlight(@PathVariable Integer id) {
        flightService.deleteFlight(id);
        return new ResponseEntity<String>("flight with this number  "+ id + " deleted successfully" , HttpStatus.OK);

    }

}
