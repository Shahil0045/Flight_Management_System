package com.FlightManagementSystem.controller;

import com.FlightManagementSystem.entity.Airport;
import com.FlightManagementSystem.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/* http://localhost:9998/airport/addAirport */
/* http://localhost:9998/airport/airportList */
/* http://localhost:9998/airport/airportList/ */

/*
{
    "airportCode" : "",
    "airportName" : "",
    "airportLocation" : ""
}
*/

@RestController
@RequestMapping(value ="/airport")
public class AirportController {

    @Autowired
    private AirportService airportService;

    List<Airport> airportList;
    @PostMapping(value = "/addAirport")
    public ResponseEntity<Airport> addAirport(@RequestBody Airport a){
        return new ResponseEntity<Airport>(airportService.addAirport(a),HttpStatus.CREATED);
    }

    @GetMapping(value = "/airportList" )
    public ResponseEntity<List<Airport>> viewAirport() {

        return ResponseEntity.ok(airportService.viewAirport());
    }

    @GetMapping(value = "/airportList/{va}" )
    public ResponseEntity<Airport> viewAirport(@PathVariable String va) {
        Airport air = airportService.viewAirport(va);
        return new ResponseEntity<Airport>(air,HttpStatus.OK);
    }

}
