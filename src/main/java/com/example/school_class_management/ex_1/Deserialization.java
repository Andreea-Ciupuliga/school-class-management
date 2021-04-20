package com.example.school_class_management.ex_1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Deserialization {

    public static void main(String[] args) {

       Animal animal;

        try (ObjectInputStream fin = new ObjectInputStream(new FileInputStream("school-class-management/src/main/java/com/example/school_class_management/ex_1/obj.txt")))
        {
            animal =(Animal)fin.readObject();

            System.out.println(animal);
        }



        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }



    }
}
