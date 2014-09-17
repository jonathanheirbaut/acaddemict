package com.realdolmen.jpa.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by JHRAU70 on 10/09/2014.
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Flight {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(nullable = false)
    private String flightNumber;
    @Temporal(TemporalType.TIMESTAMP)
    private Date departureDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date arrivalDate;


    @OneToMany(mappedBy = "flight")
    private List<Ticket> tickets = new ArrayList<>();

    protected Flight() {
    }

    public Flight(String flightNumber, Date departureDate, Date arrivalDate) {
        this.flightNumber = flightNumber;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
    }

    public Integer getId() {
        return id;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }
}
