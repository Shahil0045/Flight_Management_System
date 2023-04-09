package com.FlightManagementSystem.controller;

import com.FlightManagementSystem.entity.Booking;
import com.FlightManagementSystem.entity.Flight;
import com.FlightManagementSystem.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value ="/booking")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    List<Booking> bookingList;

    @PostMapping(value = "/addBooking")
    public ResponseEntity<Booking> addBooking(@RequestBody Booking booking) {

        return new ResponseEntity<Booking>(bookingService.addBooking(booking), HttpStatus.CREATED);
    }

    @PutMapping(value = "/modifyBooking")
    public ResponseEntity<Booking> modifyBooking(@RequestBody Booking mod) {
        Booking newFlight = bookingService.modifyBooking(mod);
        return new ResponseEntity<Booking>(mod,HttpStatus.OK);
    }

    @GetMapping(value = "/viewBooking/{id}")
    public ResponseEntity<List<Booking>> viewBooking(@PathVariable Integer id) {
        return ResponseEntity.ok(bookingService.viewBooking(id));
    }

    @GetMapping(value = "/viewBooking")
    public ResponseEntity<List<Booking>> viewBooking() {
        return new ResponseEntity<List<Booking>>(bookingService.viewBooking(),HttpStatus.OK);
    }

    @DeleteMapping(value = "/deleteBooking/{id}")
    public ResponseEntity<String> deleteBooking(@PathVariable Integer id) {
        bookingService.deleteBooking(id);
        return new ResponseEntity<String>("Booking with Id  "+ id + " deleted successfully" , HttpStatus.OK);
    }

}
