package com.example.school_class_management.ex_2;

import java.io.Serializable;

public class Vehicle implements Serializable {

    private String brand;
    private int year;

    public Vehicle(String brand, int year) {
        this.brand = brand;
        this.year = year;
    }

    public String getBrand() {
        return brand;
    }

    public int getYear() {
        return year;
    }




}
