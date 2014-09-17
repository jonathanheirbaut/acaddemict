package com.realdolmen.jpa.dao;

import com.realdolmen.jpa.DataSetPersistenceTest;
import com.realdolmen.jpa.domain.Passenger;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by JHRAU70 on 11/09/2014.
 */
public class PassengerDaoTest extends DataSetPersistenceTest {
    private PassengerDao dao;

    @Before
    public void initializePassemgerDaoTest(){
        dao = new PassengerDaoImpl(entityManager());
    }

    @Test
    public void canFindAllPassengers() throws Exception {
        List<Passenger> passengers = dao.findAll();
        assertEquals("Not all passengers could be found", 2, passengers.size());
    }

    @Test
    public void canFindAllLastNames() throws Exception {
        List<String> retrievedLastNames = dao.findAllLastNames();
        List<String> lastNames = new ArrayList<>();
        lastNames.add("Orwell");
        lastNames.add("Jerry");
        assertTrue("Not all lastNames could be found", retrievedLastNames.containsAll(lastNames));
        assertEquals("Not all lastNames could be found", lastNames.size(), retrievedLastNames.size());
    }

    @Test
    public void canRetrieveTotelFrequentFlyerMiles() throws Exception {
          assertEquals("Total frequent flyer miles could not be retrieved", new Integer(1000), dao.totalfrequentFlyerMiles());
    }

    @Test
    public void canDeleteAll() throws Exception {
        dao.deleteAll();
        entityManager().flush();
        assertEquals("Could not delete all passengers", 0, dao.findAll().size());
    }

}
