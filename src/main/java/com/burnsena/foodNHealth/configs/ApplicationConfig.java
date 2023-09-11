package com.burnsena.foodNHealth.configs;

import com.burnsena.foodNHealth.entities.AppUser;
import com.burnsena.foodNHealth.repositories.AppUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.regex.Pattern;

@Configuration
@RequiredArgsConstructor
public class ApplicationConfig {
    private final AppUserRepository userRepository;

    @Bean
    public UserDetailsService userDetailsService(){
        System.out.println("my user details service");
        return username -> {
            AppUser appUser = null;
            appUser = isEmail(username) ?
                    userRepository.findByEmail(username).orElseThrow(()-> new UsernameNotFoundException("User not found"))
                    : userRepository.findByUsername(username).orElseThrow(()-> new UsernameNotFoundException("User not found"));
            return User.builder()
                    .username(appUser.getUsername())
                    .authorities(new SimpleGrantedAuthority(appUser.getUserRole().name()))
                    .disabled(!appUser.isActive())
                    .build();
        };
    }

    private boolean isEmail(String input) {
        //rfc5322 regular expression
        String regexPattern = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
        return Pattern.compile(regexPattern).matcher(input).matches();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        System.out.println("my authentication provider");
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
