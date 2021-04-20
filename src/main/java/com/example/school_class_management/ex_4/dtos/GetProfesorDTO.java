package com.example.school_class_management.ex_4.dtos;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor

public class GetProfesorDTO {

    private String firstName;

    private String lastName;

    private String materia;

    private Long nrOre;
}
