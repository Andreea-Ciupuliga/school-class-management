package com.example.school_class_management.ex_4.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;




@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor

public class GetStudentDTO {


    private String firstName;

    private String lastName;

    private Long medie;

    private String clasa;

    private Long nrAbsente;
}
