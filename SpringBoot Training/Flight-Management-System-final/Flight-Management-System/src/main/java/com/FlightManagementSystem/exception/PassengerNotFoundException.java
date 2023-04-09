package com.FlightManagementSystem.exception;

public class PassengerNotFoundException extends RuntimeException{

    public PassengerNotFoundException() {
    }

    public PassengerNotFoundException(String message) {
        super(message);
    }
}
