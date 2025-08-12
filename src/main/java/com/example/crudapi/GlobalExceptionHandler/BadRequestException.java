package com.example.crudapi.GlobalExceptionHandler;

public class BadRequestException extends RuntimeException {
    public BadRequestException(String message) {
        super(message);
}
}