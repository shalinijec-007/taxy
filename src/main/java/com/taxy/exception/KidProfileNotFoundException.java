package com.taxy.exception;

public class KidProfileNotFoundException extends RuntimeException {

    public KidProfileNotFoundException(String username) {
        super("Kid profile not found for username: " + username);
    }
}