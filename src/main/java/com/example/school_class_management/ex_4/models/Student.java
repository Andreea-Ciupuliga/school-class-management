package com.example.school_class_management.ex_4.models;


import lombok.*;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)

@Entity
@Table(name = "student")

public class Student extends Person {

    @Column(name = "medie")
    private Long medie;

    @Column(name = "clasa")
    private String clasa;

    @Column(name = "nr_absente")
    private Long nrAbsente;


    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + getFirstName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", age=" + getAge() +
                ", adress='" + getAdress() + '\'' +
                ", medie=" + medie +
                ", clasa='" + clasa + '\'' +
                ", nrAbsente=" + nrAbsente +
                '}';
    }
}
