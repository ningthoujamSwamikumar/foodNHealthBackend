package com.burnsena.foodNHealth.entities;

import com.burnsena.foodNHealth.enums.UserRole;
import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@RequiredArgsConstructor
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Nonnull
    @Column(unique = true)
    private String email;
    private String name;
    @Nonnull
    @Column(unique = true)
    private String username;
    @Nonnull
    private String password;
    @Nonnull
    @Enumerated(EnumType.STRING)
    private UserRole userRole;
    private boolean isActive;
}
