package com.FlightManagementSystem.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import javax.persistence.*;

import java.util.Date;

@Entity
public class Booking {

    @Id
    @GeneratedValue
    Integer bookingId;

    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    User userId;
    @JsonFormat(pattern = "yyyy/MM/dd")
    Date bookingDate;
    Double ticketCost;
    Integer noOfPassenger;
    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    Flight flight;
    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "p_b")
    Passenger passenger;

    public Booking() {
    }

    public Booking(Integer bookingId, User userId, Date bookingDate, Double ticketCost, Integer noOfPassenger, Flight flight, Passenger passenger) {
        this.bookingId = bookingId;
        this.userId = userId;
        this.bookingDate = bookingDate;
        this.ticketCost = ticketCost;
        this.noOfPassenger = noOfPassenger;
        this.flight = flight;
        this.passenger = passenger;
    }

    public Integer getBookingId() {
        return bookingId;
    }

    public void setBookingId(Integer bookingId) {
        this.bookingId = bookingId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public Double getTicketCost() {
        return ticketCost;
    }

    public void setTicketCost(Double ticketCost) {
        this.ticketCost = ticketCost;
    }

    public Integer getNoOfPassenger() {
        return noOfPassenger;
    }

    public void setNoOfPassenger(Integer noOfPassenger) {
        this.noOfPassenger = noOfPassenger;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

}