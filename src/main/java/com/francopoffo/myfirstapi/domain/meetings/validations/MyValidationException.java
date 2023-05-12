package com.francopoffo.myfirstapi.domain.meetings.validations;

public class MyValidationException extends RuntimeException {
    public MyValidationException(String message) {
        super(message);
    }
}
