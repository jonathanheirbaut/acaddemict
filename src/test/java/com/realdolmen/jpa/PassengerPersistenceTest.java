package com.realdolmen.jpa;

import com.realdolmen.jpa.domain.Address;
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
public class PassengerPersistenceTest extends DataSetPersistenceTest {
    @Test
    public void passengerCanBePersisted() throws Exception {
        Passenger passenger = new Passenger("15-123456-45", "Heirbaut", "Jonathan", new Date(), PassengerType.OCCASIONAL,
                new Address("Schoolstraat 101", "","Wijnegem","2110","Belgie"));
        entityManager().persist(passenger);
        assertNotNull(passenger.getId());
    }

    @Test
    public void passengerCanBeRetrievedDBUnit() throws Exception {
        Passenger passenger = entityManager().find(Passenger.class, 1);
        assertEquals("George",passenger.getFirstName());
    }

    @Test
    public void passengerCanBeUpdated() throws Exception {
        Passenger passenger = new Passenger("15-123456-45", "Heirbaut", "Jonathan", new Date(), PassengerType.OCCASIONAL,
                new Address("Schoolstraat 101", "","Wijnegem","2110","Belgie"));
        entityManager().persist(passenger);
        passenger.setType(PassengerType.REGULAR);
        Passenger retrievedPassenger = entityManager().find(Passenger.class, passenger.getId());
        assertEquals(passenger, retrievedPassenger);
    }

    @Test
    public void passengerAgeIsCorrect() throws Exception {
        Passenger passenger = new Passenger("15-123456-45", "Heirbaut", "Jonathan", new Date(633243600000L), PassengerType.OCCASIONAL,
                new Address("Schoolstraat 101", "","Wijnegem","2110","Belgie"));
        entityManager().persist(passenger);

        Passenger retrievedPassenger = entityManager().find(Passenger.class, passenger.getId());
        assertEquals(24, retrievedPassenger.getAge());
    }

    @Test
    public void passengerLastUpdatedIsSet() throws Exception {
        Passenger passenger = new Passenger("15-123456-45", "Heirbaut", "Jonathan", new Date(), PassengerType.OCCASIONAL,
                new Address("Schoolstraat 101", "","Wijnegem","2110","Belgie"));
        entityManager().persist(passenger);

        Passenger retrievedPassenger = entityManager().find(Passenger.class, passenger.getId());
        assertNotNull(retrievedPassenger.getLastUpdated());
    }


}
