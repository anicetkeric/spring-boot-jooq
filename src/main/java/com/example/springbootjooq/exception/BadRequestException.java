package com.example.springbootjooq.exception;

/**
 * trigger for bad request exception
 */
public class BadRequestException extends ServiceException {
    public BadRequestException(String message) {
        super(message);
    }
}
