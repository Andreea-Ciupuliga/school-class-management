package com.example.school_class_management.ex_2;

public class Car  extends Vehicle {

    private String model;
    private String color;
    private double price;

    public Car(String brand, int year, String model, String color, double price) {
        super(brand, year);
        this.model = model;
        this.color = color;
        this.price = price;
    }


    @Override
    public String toString() {
        return "Car{" +
                "year=" + getYear() +
                ", brand='" + getBrand()+ '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", price=" + price +
                '}';
    }


}
