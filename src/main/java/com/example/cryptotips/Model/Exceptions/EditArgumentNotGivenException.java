package com.example.cryptotips.Model.Exceptions;

public class EditArgumentNotGivenException extends RuntimeException {
    public EditArgumentNotGivenException() {
        super("Edit method in MYPOST called with empty argument");
    }
}
