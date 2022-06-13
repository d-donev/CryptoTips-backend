package com.example.cryptotips.Model.Exceptions;

public class UsernameNotFoundException extends RuntimeException {

    public UsernameNotFoundException(String id) {
        super(String.format("User with username: %s is not found!",id));
    }

}
