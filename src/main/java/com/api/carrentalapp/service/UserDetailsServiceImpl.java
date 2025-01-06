package com.api.carrentalapp.service;

import com.api.carrentalapp.model.ConfirmationToken;
import com.api.carrentalapp.repository.ConfirmationTokenRepository;
import com.api.carrentalapp.security.JwtUserDetails;
import com.api.carrentalapp.model.User;
import com.api.carrentalapp.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    ConfirmationTokenRepository confirmationTokenRepository;

    @Autowired
    EmailService emailService;


    //implement ettiğimiz yer yanlış
    //@Override
    public ResponseEntity<String> saveUser(User user) {
        if (userRepository.existsByUserEmail(user.getEmail())) {
            return ResponseEntity.badRequest().body("Error: Email is already in use!");
        }
        userRepository.save(user);

        ConfirmationToken confirmationToken = new ConfirmationToken();

        confirmationTokenRepository.save(confirmationToken);

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(user.getEmail());
        mailMessage.setSubject("Complete Registration.");
        mailMessage.setText("To confirm your account. "
                + "http://localhost:8085/confirm-account?token=" + confirmationToken.getConfirmationToken());
        emailService.sendEmail(user.getEmail(), mailMessage.getSubject(), mailMessage.getText());

        return ResponseEntity.ok("User registered successfully.");
    }

    //Springin "UserDetailsService" katmanından çekiyor
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        return JwtUserDetails.create(user);
    }
    //Springin "UserDetailsService" katmanından çekiyor
    public UserDetails loadUserById(Long id) {
        User user = userRepository.findById(id).get();
        return JwtUserDetails.create(user);
    }
}
