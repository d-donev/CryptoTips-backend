package com.example.cryptotips.Model.Exceptions;

public class CreateArgumentNotGivenException extends RuntimeException {
    public CreateArgumentNotGivenException() {
        super("Create method in MYPOST called with empty argument");
    }
}
