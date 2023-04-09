package com.FlightManagementSystem.entity;

import javax.persistence.*;

@Entity
public class ScheduledFlight {

    @Id
    @Column(name = "scheduledFlightId")
    private Integer scheduledFlightId;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Flight flight;

    private Integer availableSeats;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)

    private Schedule schedule;

    public Integer getScheduledFlightId() {
        return scheduledFlightId;
    }

    public void setScheduledFlightId(Integer scheduledFlightId) {
        this.scheduledFlightId = scheduledFlightId;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public Integer getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(Integer availableSeats) {
        this.availableSeats = availableSeats;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

}