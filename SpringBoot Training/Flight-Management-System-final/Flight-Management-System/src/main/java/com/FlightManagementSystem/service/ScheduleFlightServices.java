package com.FlightManagementSystem.service;

import com.FlightManagementSystem.entity.Airport;
import com.FlightManagementSystem.entity.Flight;
import com.FlightManagementSystem.entity.Schedule;
import com.FlightManagementSystem.entity.ScheduledFlight;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.List;

public interface ScheduleFlightServices {

    ScheduledFlight scheduleFlight(ScheduledFlight sf);

    List<ScheduledFlight> viewScheduledFlight(Integer scheduledFlightId);

     Flight viewScheduledFlights(Integer fn);

    List<ScheduledFlight> viewScheduledFlight();

    ScheduledFlight modifyScheduledFlight(ScheduledFlight scheduledFlight);
            void deleteScheduledFlight(Integer scheduledFlightId);

}
