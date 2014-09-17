package com.realdolmen.jpa.domain;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by JHRAU70 on 10/09/2014.
 */
@Entity
public class DomesticFlight extends Flight {
    private String airlineCompany;
    @ElementCollection
    @Column(name = "flight_reference")
    private List<String> references = new ArrayList<>();

    protected DomesticFlight() {
    }

    public DomesticFlight(String flightNumber, Date departureDate, Date arrivalDate, String airlineCompany) {
        super(flightNumber, departureDate, arrivalDate);
        this.airlineCompany = airlineCompany;
    }

    public String getAirlineCompany() {
        return airlineCompany;
    }

    public void setAirlineCompany(String airlineCompany) {
        this.airlineCompany = airlineCompany;
    }

    public List<String> getReferences() {
        return references;
    }

    public void setReferences(List<String> references) {
        this.references = references;
    }
}
