package com.FlightManagementSystem.controller;

import com.FlightManagementSystem.entity.Passenger;
import com.FlightManagementSystem.entity.Schedule;
import com.FlightManagementSystem.service.PassengerService;
import com.FlightManagementSystem.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/schedule")
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;

    @PostMapping(value = "/addSchedule")
    public ResponseEntity<Schedule> addFlight(@RequestBody Schedule s) {
        return new ResponseEntity<Schedule>(scheduleService.addSchedule(s), HttpStatus.CREATED);
    }

}
