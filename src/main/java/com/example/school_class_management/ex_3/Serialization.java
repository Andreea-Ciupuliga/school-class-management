package com.example.school_class_management.ex_3;

import com.example.school_class_management.ex_1.Animal;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Serialization {

    public static void main(String[] args) {

        Animal animal[]=new Animal[5];



        animal[0] = new Animal("Toto","dog","black",20);
        animal[1] = new Animal("Max","rabbit","white",2.5);
        animal[2] = new Animal("Lucy","cat","orange",3.6);
        animal[3] = new Animal("Domino","horse","brown",450);
        animal[4] = new Animal("Camille","lizard","green",0.5);



        try (ObjectOutputStream fout = new ObjectOutputStream(new FileOutputStream("school-class-management/src/main/java/com/example/school_class_management/ex_3/obj.txt"))) {
            fout.writeObject(animal);
        }

        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
