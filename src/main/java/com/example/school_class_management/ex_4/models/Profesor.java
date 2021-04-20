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
@Table(name = "profesor")
public class Profesor extends Person {

    @Column(name = "materia")
    private String materia;

    @Column(name = "nr_ore")
    private Long nrOre;


    @Override
    public String toString() {
        return "Profesor{" +
                "firstName='" + getFirstName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", age=" + getAge() +
                ", adress='" + getAdress() + '\'' +
                ", materia='" + materia + '\'' +
                ", nrOre=" + nrOre +
                '}';
    }
}
