package com.drona.dronaapp.exception;

import lombok.Getter;

@Getter
public class UserException extends RuntimeException {
    private final String userName;

    public UserException(String userName) {
        super("User not found with userName: " + userName);
        this.userName = userName;
    }
}
