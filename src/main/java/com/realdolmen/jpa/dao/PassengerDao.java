package com.realdolmen.jpa.dao;

import com.realdolmen.jpa.domain.Passenger;
import com.realdolmen.jpa.domain.Ticket;

import java.util.List;

/**
 * Created by JHRAU70 on 11/09/2014.
 */
public interface PassengerDao {
    List<Passenger> findAll();
    List<String> findAllLastNames();
    Integer totalfrequentFlyerMiles();
    List<Ticket> findTicketsByPassengerId(Integer id);
    void deleteAll();
}
