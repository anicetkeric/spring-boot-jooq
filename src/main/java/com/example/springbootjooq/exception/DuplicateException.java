package com.example.springbootjooq.exception;

/**
 * trigger for duplicate exception
 */
public class DuplicateException extends ServiceException {
    public DuplicateException() {
        super();
    }

    public DuplicateException(String message) {
        super(message);
    }

    public DuplicateException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
