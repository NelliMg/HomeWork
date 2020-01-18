package com.company.university.customExceptions;

public class NoStudentException extends RuntimeException {
    public NoStudentException(String s) {
        super(s);
    }
}
