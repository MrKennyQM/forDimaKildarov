package com.example.demo1.exception;

public class StringException extends RuntimeException{
    public StringException(String message) {
        super(message);
    }

    public StringException(Throwable cause) {
        super(cause);
    }
}
