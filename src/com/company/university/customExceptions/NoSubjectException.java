package com.company.university.customExceptions;

public class NoSubjectException extends RuntimeException {
    public NoSubjectException(String message) {
        super(message);
    }
}
