package com.api.carrentalapp.request;


public record RegisterRequest (
        String username,
        String surname,
        String password,
        String email
) {
}
