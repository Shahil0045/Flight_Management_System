package com.FlightManagementSystem.repository;

import com.FlightManagementSystem.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface FlightRepository extends JpaRepository<Flight,Integer> {
}