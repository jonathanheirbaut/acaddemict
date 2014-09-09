package com.realdolmen.jpa.domain;

import org.joda.time.LocalDate;
import org.joda.time.Years;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


/**
 * Created by JHRAU70 on 8/09/2014.
 */
@Entity
public class Passenger implements Serializable{
    @Id
    @GeneratedValue
    private Integer id;
    @Column(nullable = false, updatable = false)
    private String ssn;
    @Column(length = 50)
    private String firstName;
    @Column(length = 50)
    private String lastName;
    private int frequentFlyerMiles;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PassengerType type;
    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.DATE)
    private Date birthDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastFlight;
    @Transient
    private int age;
    @Basic(fetch = FetchType.LAZY)
    @Lob
    private byte[] picture;

    protected Passenger() {
    }

    public Passenger(String ssn, String firstName, String lastName, Date birthDate, PassengerType type) {
        this.ssn = ssn;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public String getSsn() {
        return ssn;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getFrequentFlyerMiles() {
        return frequentFlyerMiles;
    }

    public PassengerType getType() {
        return type;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public Date getLastFlight() {
        return lastFlight;
    }

    public int getAge() {
        LocalDate birthdate = new LocalDate (1970, 1, 20);
        LocalDate now = new LocalDate();
        Years age = Years.yearsBetween(birthdate, now);
        return age.getYears();
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setFrequentFlyerMiles(int frequentFlyerMiles) {
        this.frequentFlyerMiles = frequentFlyerMiles;
    }

    public void setType(PassengerType type) {
        this.type = type;
    }

    public void setLastFlight(Date lastFlight) {
        this.lastFlight = lastFlight;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }
}
