package com.example.school_class_management.ex_4.exceptions;

public class CustomBadRequestException extends Exception{

    public CustomBadRequestException(String errorMessage) {
        super(errorMessage);
    }

}

