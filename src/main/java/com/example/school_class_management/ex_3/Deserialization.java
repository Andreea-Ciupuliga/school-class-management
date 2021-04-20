package com.example.school_class_management.ex_3;

import com.example.school_class_management.ex_1.Animal;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Scanner;

public class Deserialization {

    public static void main(String[] args) {

       Animal animal[];

        Scanner sc = new Scanner(System.in);

        System.out.println("enter the object id ");
        int id = sc.nextInt();



        try (ObjectInputStream fin = new ObjectInputStream(new FileInputStream("school-class-management/src/main/java/com/example/school_class_management/ex_3/obj.txt")))
        {
            animal =(Animal [])fin.readObject();

            //for(int i=0;i< animal.length;i++)
             //       System.out.println(animal[i]);

            System.out.println(animal[id]);

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
