package com.FlightManagementSystem.repository;

import com.FlightManagementSystem.entity.Airport;
//import com.FlightManagementSystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirportRepository extends JpaRepository<Airport,String>{
}
