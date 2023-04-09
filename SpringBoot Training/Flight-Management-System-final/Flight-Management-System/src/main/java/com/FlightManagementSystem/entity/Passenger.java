package com.FlightManagementSystem.entity;

import javax.persistence.*;
import org.hibernate.engine.internal.Cascade;

import java.util.*;

@Entity
public class Passenger {

    @Id
    private Integer pnrNumber;
    private String passengerName;
    private Integer passengerAge;
    private Integer passengerUIN;
    private Double Luggage;

    public Passenger() {
    }

    public Integer getPnrNumber() {
        return pnrNumber;
    }

    public void setPnrNumber(Integer pnrNumber) {
        this.pnrNumber = pnrNumber;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public Integer getPassengerAge() {
        return passengerAge;
    }

    public void setPassengerAge(Integer passengerAge) {
        this.passengerAge = passengerAge;
    }

    public Integer getPassengerUIN() {
        return passengerUIN;
    }

    public void setPassengerUIN(Integer passengerUIN) {
        this.passengerUIN = passengerUIN;
    }

    public Double getLuggage() {
        return Luggage;
    }

    public void setLuggage(Double luggage) {
        Luggage = luggage;
    }

}
