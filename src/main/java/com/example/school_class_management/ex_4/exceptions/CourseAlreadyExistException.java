package com.example.school_class_management.ex_4.exceptions;

public class CourseAlreadyExistException extends Exception{

    public CourseAlreadyExistException(String errorMessage) {
        super(errorMessage);
    }

}
