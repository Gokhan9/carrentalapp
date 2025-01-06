package com.api.carrentalapp.repository;

import com.api.carrentalapp.dto.UserDto;
import com.api.carrentalapp.model.ConfirmationToken;
import com.api.carrentalapp.model.User;
import org.antlr.v4.runtime.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

    User save(UserDto userDto);

    Token save(ConfirmationToken confirmationToken);

    boolean existsByUserEmail(String email);
}
