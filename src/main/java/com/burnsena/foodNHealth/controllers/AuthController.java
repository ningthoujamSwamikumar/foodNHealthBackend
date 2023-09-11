package com.burnsena.foodNHealth.controllers;

import com.burnsena.foodNHealth.dto.AuthRequest;
import com.burnsena.foodNHealth.dto.AuthResponse;
import com.burnsena.foodNHealth.entities.AppUser;
import com.burnsena.foodNHealth.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;
    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest request){
        return authService.login(request);
    }

    @PostMapping("/register")
    public AuthResponse register(@RequestBody AppUser appUser){
        return authService.register(appUser);
    }

}
