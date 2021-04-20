package com.example.school_class_management.ex_4.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.io.Serializable;

@SuperBuilder
@Data
@AllArgsConstructor
@NoArgsConstructor

@MappedSuperclass
public class Person implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
   private String firstName;

    @Column(name = "last_name")
   private String lastName;

    @Column(name = "age")
   private Long age;

    @Column(name = "adress")
   private String adress;

}
