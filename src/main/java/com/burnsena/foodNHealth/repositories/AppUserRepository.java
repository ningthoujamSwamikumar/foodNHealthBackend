package com.burnsena.foodNHealth.repositories;

import com.burnsena.foodNHealth.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    public Optional<AppUser> findByEmail(String email);
    public Optional<AppUser> findByUsername(String username);
}
