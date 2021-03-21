package com.fahrecker.springboottutbootstrap.persistence.model;

import javax.persistence.*;

@Entity
public class Movie {
    public long getId() {
        return id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false, unique = true)
    private String title;

    @Column(nullable = false)
    private String director;
}
