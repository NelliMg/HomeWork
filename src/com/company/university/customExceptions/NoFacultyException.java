package com.company.university.customExceptions;

public class NoFacultyException  extends RuntimeException{
    public NoFacultyException(String message) {
        super(message);
    }
}
