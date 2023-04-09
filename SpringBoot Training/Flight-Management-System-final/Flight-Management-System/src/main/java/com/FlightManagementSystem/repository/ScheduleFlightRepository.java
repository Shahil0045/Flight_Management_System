package com.FlightManagementSystem.repository;

import com.FlightManagementSystem.entity.ScheduledFlight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleFlightRepository extends JpaRepository<ScheduledFlight,Integer>{
}
