package com.example.school_class_management.ex_4.service;


import com.example.school_class_management.ex_4.dtos.GetProfesorDTO;
import com.example.school_class_management.ex_4.dtos.RegisterProfesorDTO;
import com.example.school_class_management.ex_4.exceptions.ProfesorAlreadyExistException;
import com.example.school_class_management.ex_4.exceptions.ProfesorNotFoundException;
import com.example.school_class_management.ex_4.models.Profesor;
import com.example.school_class_management.ex_4.repository.ProfesorRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;

@Service
public class ProfesorService {
    private ProfesorRepository profesorRepository;

    @Autowired
    public ProfesorService(ProfesorRepository profesorRepository) {
        this.profesorRepository = profesorRepository;
    }

    @SneakyThrows
    public void registerProfesor(RegisterProfesorDTO registerProfesorDTO)
    {
        if(profesorRepository.findByFirstName(registerProfesorDTO.getFirstName()).isPresent())
        {
            throw new ProfesorAlreadyExistException("exista deja profesorul");
        }

        Profesor profesor=Profesor.builder()
                .firstName(registerProfesorDTO.getFirstName())
                .lastName(registerProfesorDTO.getLastName())
                .adress(registerProfesorDTO.getAdress())
                .age(registerProfesorDTO.getAge())
                .nrOre(registerProfesorDTO.getNrOre())
                .materia(registerProfesorDTO.getMateria()) .build();


        profesorRepository.save(profesor);

        serializationProfesor(profesor);

        System.out.println(deserializationProfesor());

    }




    @SneakyThrows
    public void putProfesor(Long profesorId, RegisterProfesorDTO newRegisterProfesorDTO) {

        Profesor profesor = profesorRepository.findById(profesorId).orElseThrow(()->new ProfesorNotFoundException("profesor not found"));

        if(newRegisterProfesorDTO.getFirstName()!=null)
            profesor.setFirstName(newRegisterProfesorDTO.getFirstName());

        if(newRegisterProfesorDTO.getLastName()!=null)
            profesor.setLastName(newRegisterProfesorDTO.getLastName());

        if(newRegisterProfesorDTO.getAdress()!=null)
            profesor.setAdress(newRegisterProfesorDTO.getAdress());

        if(newRegisterProfesorDTO.getAge()!=null)
            profesor.setAge(newRegisterProfesorDTO.getAge());

        if(newRegisterProfesorDTO.getNrOre()!=null)
            profesor.setNrOre(newRegisterProfesorDTO.getNrOre());

        if(newRegisterProfesorDTO.getMateria()!=null)
            profesor.setMateria(newRegisterProfesorDTO.getMateria());


        profesorRepository.save(profesor);

    }


    @SneakyThrows
    public void removeProfesor(Long profesorId)
    {

        Profesor profesor=profesorRepository.findById(profesorId).orElseThrow(()-> new ProfesorNotFoundException("nu avem acest profesor"));
        profesorRepository.delete(profesor);
    }


    @SneakyThrows
    public void removeAllProfesors()
    {
        profesorRepository.deleteAll();
    }

    @SneakyThrows
    public GetProfesorDTO getProfesor(Long profesorId)
    {
       Profesor profesor = profesorRepository.findById(profesorId).orElseThrow(()->new ProfesorNotFoundException("profesor not found"));

        GetProfesorDTO getprofesorDTO= GetProfesorDTO.builder()
                .firstName(profesor.getFirstName())
                .lastName(profesor.getLastName())
                .materia(profesor.getMateria())
                .nrOre(profesor.getNrOre()).build();

        return getprofesorDTO;
    }


    public void serializationProfesor(Profesor profesor) {

        try (ObjectOutputStream fout = new ObjectOutputStream(new FileOutputStream("school-class-management/src/main/java/com/example/school_class_management/ex_4/Profesor.txt"))) {
            fout.writeObject(profesor);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @SneakyThrows
    public Profesor deserializationProfesor()
    {
        Profesor profesor;

        ObjectInputStream fin = new ObjectInputStream(new FileInputStream("school-class-management/src/main/java/com/example/school_class_management/ex_4/Profesor.txt"));

        profesor =(Profesor)fin.readObject();

        return profesor;

    }


}
