package com.FlightManagementSystem.entity;

import javax.persistence.*;

@Entity
public class Airport {

    @Id
    private String airportCode;
    private String airportName;
    private String airportLocation;

    public Airport() {
    }

    public Airport(String airportCode, String airportName, String airportLocation) {
        this.airportCode = airportCode;
        this.airportName = airportName;
        this.airportLocation = airportLocation;
    }

    public String getAirportName() {
        return airportName;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }

    public String getAirportCode() {
        return airportCode;
    }

    public void setAirportCode(String airportCode) {
        this.airportCode = airportCode;
    }

    public String getAirportLocation() {
        return airportLocation;
    }

    public void setAirportLocation(String airportLocation) {
        this.airportLocation = airportLocation;
    }

}
