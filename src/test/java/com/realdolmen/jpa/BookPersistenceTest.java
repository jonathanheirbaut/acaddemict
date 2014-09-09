package com.realdolmen.jpa;

import com.realdolmen.jpa.domain.Book;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by JHRAU70 on 8/09/2014.
 */
public class BookPersistenceTest extends PersistenceTest {
    @Test
    public void booksCanBePersisted() throws Exception {
        Book book = new Book("Animal Farm", "Orwell");
        entityManager().persist(book);
        book.getId();

        assertNotNull(book.getId());


    }
}
