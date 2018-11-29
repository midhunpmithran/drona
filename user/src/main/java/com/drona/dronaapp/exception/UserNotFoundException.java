package com.drona.dronaapp.exception;

import lombok.Getter;

@Getter
public class UserNotFoundException extends RuntimeException {
    private final String userName;

    public UserNotFoundException(String userName) {
        super("User not found with userName: " + userName);
        this.userName = userName;
    }
}
