package com.realdolmen.jpa.dao;

import com.realdolmen.jpa.domain.Passenger;
import com.realdolmen.jpa.domain.Ticket;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by JHRAU70 on 11/09/2014.
 */
public class PassengerDaoImpl implements PassengerDao {
    private EntityManager em;

    public PassengerDaoImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Passenger> findAll() {
      return em.createQuery("SELECT p FROM Passenger p", Passenger.class).getResultList();
    }

    @Override
    public List<String> findAllLastNames() {
        return em.createQuery("SELECT p.lastName FROM Passenger p", String.class).getResultList();
    }

    @Override
    public Integer totalfrequentFlyerMiles() {
        return Integer.parseInt("" + em.createQuery("SELECT SUM(p.frequentFlyerMiles) FROM Passenger p", Integer.class).getSingleResult());
    }

    @Override
    public List<Ticket> findTicketsByPassengerId(Integer id) {
        return em.createQuery("SELECT p.tickets FROM Passenger p", Ticket.class).getResultList();
    }

    @Override
    public void deleteAll() {
       em.createQuery("DELETE  FROM Passenger p");
    }
}
