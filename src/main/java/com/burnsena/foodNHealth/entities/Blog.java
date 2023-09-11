package com.burnsena.foodNHealth.entities;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Entity
@Builder
@Data
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date created;
    private Date modified;
    private String content;
    private String title;
    //will change with user type
    @ManyToOne
    private AppUser author;
    @ManyToMany
    private List<Tag> tags;
}
