package com.burnsena.foodNHealth.entities;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Builder;

@Entity
@Builder
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @ManyToOne
    private Blog blog;
    @Nullable
    @ManyToOne
    private Comment comment;
    private String content;
}
