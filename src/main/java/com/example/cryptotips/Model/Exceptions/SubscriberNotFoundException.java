package com.example.cryptotips.Model.Exceptions;

public class SubscriberNotFoundException extends RuntimeException {
    public SubscriberNotFoundException(Long id) {
        super(String.format("Subscriber with id: %d is not found!",id));
    }
}
