package com.auth.userservice.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class BcryptPassCodeEncoder {
    @Bean
    public BCryptPasswordEncoder getbcryptPassCodeEncoder() {
        return new BCryptPasswordEncoder();
    }
}
