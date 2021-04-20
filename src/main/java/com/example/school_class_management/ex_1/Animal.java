package com.example.school_class_management.ex_1;

import java.io.Serializable;

public class Animal implements Serializable {
    private String name;
    private String species;
    private String color;
    private double weight;

    public Animal(String name, String species, String color, double weight) {
        this.name = name;
        this.species = species;
        this.color = color;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", species='" + species + '\'' +
                ", color='" + color + '\'' +
                ", weight=" + weight +
                '}';
    }
}
