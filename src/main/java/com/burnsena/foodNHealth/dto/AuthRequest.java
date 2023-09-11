package com.burnsena.foodNHealth.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class AuthRequest {
    private String username; //this is either username or email
    private String password;
}
