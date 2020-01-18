package com.company.university.customExceptions;

public class NoGroupException extends RuntimeException {
    public NoGroupException(String message) {
        super(message);
    }
}
