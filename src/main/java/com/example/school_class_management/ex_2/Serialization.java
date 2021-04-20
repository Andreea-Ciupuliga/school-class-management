package com.example.school_class_management.ex_2;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Serialization {

    public static void main(String[] args) {

       Car car = new Car("Skoda",2020,"Octavia","black",20000);


        try (ObjectOutputStream fout = new ObjectOutputStream(new FileOutputStream("school-class-management/src/main/java/com/example/school_class_management/ex_2/obj.txt"))) {
            fout.writeObject(car);
        }

        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
