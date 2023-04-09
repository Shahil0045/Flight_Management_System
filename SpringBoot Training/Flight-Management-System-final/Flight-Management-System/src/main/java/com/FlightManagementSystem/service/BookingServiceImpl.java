package com.FlightManagementSystem.service;

import com.FlightManagementSystem.entity.Booking;
import com.FlightManagementSystem.entity.Flight;
import com.FlightManagementSystem.entity.Passenger;
import com.FlightManagementSystem.exception.BookingNotFoundException;
import com.FlightManagementSystem.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    BookingRepository bookingRepository;



    @Override
    public Booking addBooking(Booking booking) {

        if (bookingRepository.existsById(booking.getBookingId())) {
            throw new BookingNotFoundException("Cannot have same booking id:Already Exits");
        }
        return bookingRepository.save(booking);
    }

    @Override
    public Booking modifyBooking(Booking booking) {
        if (!bookingRepository.existsById(booking.getBookingId())) {
            throw new BookingNotFoundException("Booking Id not found for modifying");
        }
        Optional<Booking> findbyid = bookingRepository.findById(booking.getBookingId());
        if (findbyid.isPresent()) {
            bookingRepository.save(booking);
        }
        return booking;
    }

    @Override
    public List<Booking> viewBooking(Integer id) {
        if (!bookingRepository.existsById(id)) {
            throw new BookingNotFoundException("Booking with this " + id  + "Not Found");
        }
        return bookingRepository.findAllById(Collections.singleton(id));
    }

    @Override
    public List<Booking> viewBooking() {
        return bookingRepository.findAll();
    }

    @Override
    public void deleteBooking(Integer id) {
        if (!bookingRepository.existsById(id)) {
            throw new BookingNotFoundException("Booking with this " + id  + "Not Found");
        }
        bookingRepository.deleteById(id);
    }
}

