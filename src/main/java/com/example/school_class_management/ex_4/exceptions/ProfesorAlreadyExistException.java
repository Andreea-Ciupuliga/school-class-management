package com.example.school_class_management.ex_4.exceptions;

public class ProfesorAlreadyExistException extends Exception {

    public ProfesorAlreadyExistException(String errorMessage) {
        super(errorMessage);
    }
}