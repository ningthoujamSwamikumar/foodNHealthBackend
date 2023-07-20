package com.burnsena.foodNHealth.entities;

import com.burnsena.foodNHealth.enums.UserType;
import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;

@Entity
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Nonnull
    private String email;
    private String name;
    @Nonnull
    private String username;
    @Nonnull
    private UserType userType;
    private boolean isActive;
}
