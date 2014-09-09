package com.realdolmen.jpa;

import com.realdolmen.jpa.domain.Passenger;
import com.realdolmen.jpa.domain.PassengerId;
import com.realdolmen.jpa.domain.PassengerType;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by JHRAU70 on 8/09/2014.
 */
public class PassengerPersistenceTest extends PersistenceTest {
    @Test
    public void passengerCanBePersisted() throws Exception {
        Passenger passenger = new Passenger("15-123456-45", "Heirbaut", "Jonathan", new Date(), PassengerType.OCCASIONAL);
        entityManager().persist(passenger);
        assertNotNull(passenger.getId());
    }

    @Test
    public void passengerCanBeUpdated() throws Exception {
        Passenger passenger = new Passenger("15-123456-45", "Heirbaut", "Jonathan", new Date(), PassengerType.OCCASIONAL);
        entityManager().persist(passenger);
        passenger.setType(PassengerType.REGULAR);
        Passenger retrievedPassenger = entityManager().find(Passenger.class, passenger.getId());
        assertEquals(passenger, retrievedPassenger);
    }

    @Test
    public void passengerAge() throws Exception {
        Passenger passenger = new Passenger("15-123456-45", "Heirbaut", "Jonathan", new Date(633243600000L), PassengerType.OCCASIONAL);
        entityManager().persist(passenger);

        Passenger retrievedPassenger = entityManager().find(Passenger.class, passenger.getId());
        assertEquals(24, retrievedPassenger.getAge());
    }


}
