package com.burnsena.foodNHealth.dto;

import com.burnsena.foodNHealth.entities.AppUser;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
public class AuthResponse {
    private AppUser user;
    private String token;
}
