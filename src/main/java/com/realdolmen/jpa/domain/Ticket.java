package com.realdolmen.jpa.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by JHRAU70 on 9/09/2014.
 */
@Entity
public class Ticket {
    @Id
    @GeneratedValue
    private Integer id;
    private BigDecimal price;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOfDeparture;
    private String destination;

    protected Ticket() {
    }

    public Ticket(BigDecimal price, Date dateOfDeparture, String destination) {
        this.price = price;
        this.dateOfDeparture = dateOfDeparture;
        this.destination = destination;
    }

    public Integer getId() {
        return id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Date getDateOfDeparture() {
        return dateOfDeparture;
    }

    public String getDestination() {
        return destination;
    }
}
