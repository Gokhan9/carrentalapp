package com.api.carrentalapp.converter;

import com.api.carrentalapp.dto.UserDto;
import com.api.carrentalapp.model.User;
import com.api.carrentalapp.request.VehicleRequest;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Component;

@Component
public class UserDtoConverter {

    public UserDto convert(User from) {
        return new UserDto(from.getId(),
                from.getUsername(),
                from.getSurname(),
                from.getPassword());
    }

    public User toUser(UserDto dto) {

        User user = new User();

        user.setId(dto.getId());
        user.setUsername(dto.getUsername());
        user.setSurname(dto.getSurname());
        user.setPassword(dto.getPassword());

        return user;
    }

    public UserDto userDto(User user) {

        UserDto userDto = new UserDto();

        userDto.setId(user.getId());
        userDto.setUsername(user.getUsername());
        userDto.setSurname(user.getSurname());
        userDto.setPassword(user.getPassword());

        return userDto;

    }
}
