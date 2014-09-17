package com.realdolmen.jpa;

import com.realdolmen.jpa.domain.DomesticFlight;
import com.realdolmen.jpa.domain.Flight;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;

/**
 * Created by JHRAU70 on 10/09/2014.
 */
public class FlightPersistenceTest extends DataSetPersistenceTest {
    @Test
    public void flightCanBeAdded() throws Exception {
        entityManager().persist(new DomesticFlight("FL_080", new Date(), new Date(), "Delta Airlines"));
    }

    @Test
    public void testJenkinsFail(){
        System.out.println();
        assertEquals("Test has to fial", true, false);
    }
}
