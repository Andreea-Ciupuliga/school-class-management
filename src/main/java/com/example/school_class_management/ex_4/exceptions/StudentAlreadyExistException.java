package com.example.school_class_management.ex_4.exceptions;

public class StudentAlreadyExistException extends Exception {
    public StudentAlreadyExistException(String errorMessage) {
        super(errorMessage);
    }
}

