package com.FlightManagementSystem.service;

import com.FlightManagementSystem.entity.Airport;

import java.util.List;


public interface AirportService {

    Airport addAirport(Airport a);
    List<Airport> viewAirport();

    Airport viewAirport(String va);
}
