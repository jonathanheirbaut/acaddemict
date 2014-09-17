package com.realdolmen.jpa.example;

import javax.persistence.*;

/**
 * Created by JHRAU70 on 8/09/2014.
 */
@Entity
public class Book {
    public static enum Genre{
        FANTASY, THRILLER, BIOGRAPHY
    }

    @Id
    @GeneratedValue
    private Integer id;
    private String title;
    private String author;
    @Enumerated(EnumType.STRING)
    private Genre genre;

    /**
     * Used by JPA.
     */
    protected Book() {
    }

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }
}
