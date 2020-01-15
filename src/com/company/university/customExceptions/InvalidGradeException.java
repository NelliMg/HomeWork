package com.company.university.customExceptions;

public class InvalidGradeException extends RuntimeException {
    public InvalidGradeException(String s) {
        super(s);
    }
}
