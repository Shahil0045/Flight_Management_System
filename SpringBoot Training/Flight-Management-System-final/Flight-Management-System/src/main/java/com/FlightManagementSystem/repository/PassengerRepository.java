package com.FlightManagementSystem.repository;

import com.FlightManagementSystem.entity.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface PassengerRepository extends JpaRepository<Passenger, BigInteger> {
}
