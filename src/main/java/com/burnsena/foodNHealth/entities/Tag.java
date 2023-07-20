package com.burnsena.foodNHealth.entities;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.Builder;

@Entity
@Builder
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @ManyToMany
    private Blog blog;
    @Nonnull
    private String keyword;
}
