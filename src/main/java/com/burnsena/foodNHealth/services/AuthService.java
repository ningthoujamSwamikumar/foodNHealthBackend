package com.burnsena.foodNHealth.services;

import com.burnsena.foodNHealth.dto.AuthRequest;
import com.burnsena.foodNHealth.dto.AuthResponse;
import com.burnsena.foodNHealth.entities.AppUser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthService {
    private final AppUserService appUserService;
    private final TokenService tokenService;

    public AuthResponse register(AppUser appUser){
        var savedUser = appUserService.create(appUser);
        var token = tokenService.generateToken(savedUser);
        return AuthResponse.builder().user(savedUser).token(token).build();
    }

    public AuthResponse login(AuthRequest authRequest){
        log.debug("login requested for user: '{}'", authRequest.getUsername());
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        log.debug("user {} is authenticated? {}", authentication.getPrincipal(), authentication.isAuthenticated());
        String token = tokenService.generateToken(authentication);
        log.debug("Token granted: {}", token);
        return AuthResponse.builder().token(token).build();
    }
}
