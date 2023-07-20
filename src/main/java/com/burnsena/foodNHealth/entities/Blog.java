package com.burnsena.foodNHealth.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import lombok.Builder;

import java.util.Date;

@Entity
@Builder
public class Blog {
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private Date created;
    private Date modified;
    private String content;
    private String title;
    //will change with user type
    @ManyToOne
    private User author;
}
