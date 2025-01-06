package com.api.carrentalapp.service;

import com.api.carrentalapp.model.User;
import org.springframework.http.ResponseEntity;

public interface UserDetailsService {
    ResponseEntity<String> saveUser(User user);
}
