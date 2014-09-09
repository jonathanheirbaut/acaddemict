package com.realdolmen.jpa;

import com.realdolmen.jpa.domain.Ticket;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * Created by JHRAU70 on 9/09/2014.
 */
public class TicketPersistenceTest extends PersistenceTest {
    @Test
    public void ticketCanBePersisted() {
        Ticket ticket = new Ticket(new BigDecimal(95.95), new Date(), "Malaga");
        entityManager().persist(ticket);
        assertNotNull(ticket.getId());
    }

    @Test
    public void ticketCanBeMerged() {
        Ticket ticket = new Ticket(new BigDecimal(95.95), new Date(), "Malaga");
        assertNull(ticket.getId());
        ticket = entityManager().merge(ticket);
        assertNotNull("Ticket has not been merged", ticket.getId());
    }

    @Test
    public void ticketCanBeRemoved() {
        Ticket ticket = new Ticket(new BigDecimal(95.95), new Date(), "Malaga");
        entityManager().persist(ticket);
        entityManager().flush();
        entityManager().clear();
        Ticket ticketReference = entityManager().getReference(Ticket.class, ticket.getId());
        entityManager().remove(ticketReference);
        assertNull("Ticket has not been deleted", entityManager().find(Ticket.class, ticket.getId()));
    }
}
