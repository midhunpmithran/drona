package com.drona.dronaapp.exception;

import lombok.Getter;

@Getter
public class UserAuthException extends RuntimeException {
    private final String userName;

    public UserAuthException(String userName) {
        super("User not found with userName: " + userName);
        this.userName = userName;
    }
}
