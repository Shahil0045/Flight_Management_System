package com.FlightManagementSystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<String> handleUserNotFoundException(UserNotFoundException enfe){
        return new ResponseEntity<String>(enfe.getMessage(), HttpStatus.NOT_FOUND);

    }
    @ExceptionHandler(AirportNotFoundException.class)
    public ResponseEntity<String> handleAirportNotFoundException(AirportNotFoundException enfe){
        return new ResponseEntity<String>(enfe.getMessage(), HttpStatus.NOT_FOUND);

    }
    @ExceptionHandler(BookingNotFoundException.class)
    public ResponseEntity<String> handleBookingNotFoundException(BookingNotFoundException enfe){
        return new ResponseEntity<String>(enfe.getMessage(), HttpStatus.NOT_FOUND);

    }
    @ExceptionHandler(ScheduleFlightNotFoundException.class)
    public ResponseEntity<String> handleScheduleFlightNotFoundException(ScheduleFlightNotFoundException enfe){
        return new ResponseEntity<String>(enfe.getMessage(), HttpStatus.NOT_FOUND);

    }
    @ExceptionHandler(FlightNotFoundException.class)
    public ResponseEntity<String> handleFlightNotFoundException(FlightNotFoundException enfe){
        return new ResponseEntity<String>(enfe.getMessage(), HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(PassengerNotFoundException.class)
    public ResponseEntity<String> handlePassengerNotFoundException(PassengerNotFoundException enfe){
        return new ResponseEntity<String>(enfe.getMessage(), HttpStatus.NOT_FOUND);

    }
    @ExceptionHandler (MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleMethodArgsNotValidException(MethodArgumentNotValidException ex) {
        Map<String, String> resp = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String message = error.getDefaultMessage();
            resp.put(fieldName, message);
        });
        return new ResponseEntity<Map<String, String>>(resp, HttpStatus.BAD_REQUEST);
    }

}
