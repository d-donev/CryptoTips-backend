package com.example.cryptotips.Model.Exceptions;

public class AnalyzeNotFoundException extends RuntimeException {
    public AnalyzeNotFoundException(Long id) {
        super(String.format("Analyze with id: %d is not found!", id));
    }
}
