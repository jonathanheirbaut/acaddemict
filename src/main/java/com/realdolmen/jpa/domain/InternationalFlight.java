package com.realdolmen.jpa.domain;

import javax.persistence.Entity;

/**
 * Created by JHRAU70 on 10/09/2014.
 */
@Entity
public class InternationalFlight extends Flight{
    private boolean blacklisted;
    private String regulations;

    protected InternationalFlight() {
    }

    public boolean isBlacklisted() {
        return blacklisted;
    }

    public void setBlacklisted(boolean blacklisted) {
        this.blacklisted = blacklisted;
    }

    public String getRegulations() {
        return regulations;
    }

    public void setRegulations(String regulations) {
        this.regulations = regulations;
    }
}
