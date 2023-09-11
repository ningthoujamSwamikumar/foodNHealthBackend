package com.burnsena.foodNHealth.services;

import com.burnsena.foodNHealth.entities.AppUser;
import com.burnsena.foodNHealth.repositories.AppUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppUserService {
    private final AppUserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AppUser create(AppUser appUser) {
        appUser.setPassword(passwordEncoder.encode(appUser.getPassword()));
        return userRepository.save(appUser);
    }
}
