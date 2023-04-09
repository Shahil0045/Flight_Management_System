package com.FlightManagementSystem.service;

import com.FlightManagementSystem.entity.Flight;

import java.util.List;

public interface FlightService {

    Flight addFlight(Flight af);
    Flight modifyFlight(Flight mf);
    List<Flight> viewFlight(Integer fid);
    List<Flight> viewFlight();
    void deleteFlight(Integer id);

}
