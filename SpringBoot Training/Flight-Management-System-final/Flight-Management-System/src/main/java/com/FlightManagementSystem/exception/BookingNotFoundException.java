package com.FlightManagementSystem.exception;

public class BookingNotFoundException extends RuntimeException{

    public BookingNotFoundException() {
    }

    public BookingNotFoundException(String message) {
        super(message);
    }
}
