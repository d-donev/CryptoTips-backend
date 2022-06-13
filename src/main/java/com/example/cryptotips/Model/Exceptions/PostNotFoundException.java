package com.example.cryptotips.Model.Exceptions;

public class PostNotFoundException extends RuntimeException {
    public PostNotFoundException(Long id) {
        super(String.format("Post with id: %d is not found!",id));
    }
}
