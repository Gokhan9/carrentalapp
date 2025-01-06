package com.api.carrentalapp.service;

import com.api.carrentalapp.exception.UserNotFoundException;
import com.api.carrentalapp.model.ConfirmationToken;
import com.api.carrentalapp.model.User;
import com.api.carrentalapp.model.Vehicle;
import com.api.carrentalapp.repository.ConfirmationTokenRepository;
import com.api.carrentalapp.repository.UserRepository;
import com.api.carrentalapp.repository.VehicleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final VehicleRepository vehicleRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private ConfirmationTokenRepository confirmationTokenRepository;


    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User saveOneUser(User newUser) {
        return userRepository.save(newUser);
    }

    public User getOneUser(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }

    public User updateOneUser(Long userId, User newUser) {
        Optional<User> user = userRepository.findById(userId);
        if(user.isPresent()) {
            User foundUser = user.get();
            foundUser.setUsername(newUser.getUsername());
            foundUser.setPassword(newUser.getPassword());
            userRepository.save(foundUser);
            return foundUser;
        } else {
            return null;
        }
    }

    public User deleteById(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found." + userId));
        userRepository.save(user);
        return user;

    }

    public User getOneUserByUserName(String userName) {
        return userRepository.findByUsername(userName);
    }

    public User getCustomerById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User is not found by id." + id));
    }

    public String registerUser(User user) {
        if (userRepository.existsByUserEmail(user.getEmail())) {
            return "E-Mail already exists!";
        }
        //Şifreyi hashleyerek kaydediyoruz.
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return "User registered successfully.";
    }

    public ResponseEntity<?> confirmEmail(String token) {
        Optional<ConfirmationToken> confirmationToken = Optional.ofNullable(confirmationTokenRepository.findByToken(token));

        if(confirmationToken.isPresent()) {
            User user = confirmationToken
        }
    }


}
