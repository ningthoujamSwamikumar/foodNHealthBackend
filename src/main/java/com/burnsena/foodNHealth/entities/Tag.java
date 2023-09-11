package com.burnsena.foodNHealth.entities;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.Builder;

import java.util.List;

@Entity
@Builder
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Nonnull
    private String keyword;
    @ManyToMany
    private List<Blog> blogs;
}
