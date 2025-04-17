package com.example.emtlab.dto;

import com.example.emtlab.model.enumerations.Role;
import com.example.emtlab.model.User;
import com.example.emtlab.model.exceptions.PasswordsDoNotMatchException;

public record CreateUserDto(
        String username,
        String password,
        String repeatPassword,
        String name,
        String surname,
        Role role
) {

    public CreateUserDto {
        if (!password.equals(repeatPassword)) {
            throw new PasswordsDoNotMatchException();
        }
    }
    public User toUser() {
        return new User(username, password, name, surname, role);
    }
}
