package com.example.springbootjooq.exception;

/**
 * trigger for data not found exception
 */
public class DataNotFoundException extends ServiceException {
    public DataNotFoundException(String message) {
        super(message);
    }
}
