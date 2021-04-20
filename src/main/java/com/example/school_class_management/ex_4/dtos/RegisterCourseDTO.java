package com.example.school_class_management.ex_4.dtos;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterCourseDTO {


    private String courseName;

    private String professorName;

    private Long numberOfStudents;

}
