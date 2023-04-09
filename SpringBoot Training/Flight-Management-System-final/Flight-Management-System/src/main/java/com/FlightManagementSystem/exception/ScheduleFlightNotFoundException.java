package com.FlightManagementSystem.exception;

public class ScheduleFlightNotFoundException extends RuntimeException {

    public ScheduleFlightNotFoundException() {
    }

    public ScheduleFlightNotFoundException(String message) {
        super(message);
    }
}
