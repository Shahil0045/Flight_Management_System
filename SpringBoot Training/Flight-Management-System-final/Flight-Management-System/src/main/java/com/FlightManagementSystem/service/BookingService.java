package com.FlightManagementSystem.service;

import com.FlightManagementSystem.entity.Booking;
import com.FlightManagementSystem.entity.Passenger;

import java.math.BigInteger;
import java.util.List;

public interface BookingService {

    Booking addBooking(Booking booking);
    Booking modifyBooking(Booking mod);
    List<Booking> viewBooking(Integer id);
    List<Booking> viewBooking();
    void deleteBooking(Integer id);

}
