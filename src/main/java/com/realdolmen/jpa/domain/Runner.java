package com.realdolmen.jpa.domain;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by JHRAU70 on 8/09/2014.
 */
public class Runner {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        try {
        entityManagerFactory = Persistence.createEntityManagerFactory("TicketPU");
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(new Book("Title", "Author"));
        entityManager.getTransaction().commit();
        } finally {
            if (entityManager != null){
                entityManager.close();
            }
            if (entityManagerFactory != null){
                entityManagerFactory.close();
            }
        }
    }
}
