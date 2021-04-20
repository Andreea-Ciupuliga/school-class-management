package com.example.school_class_management.ex_4.service;


import com.example.school_class_management.ex_4.dtos.GetStudentDTO;
import com.example.school_class_management.ex_4.dtos.RegisterStudentDTO;
import com.example.school_class_management.ex_4.exceptions.StudentAlreadyExistException;
import com.example.school_class_management.ex_4.exceptions.StudentNotFoundException;
import com.example.school_class_management.ex_4.models.Student;
import com.example.school_class_management.ex_4.repository.StudentRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;

@Service
public class StudentService {

private StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @SneakyThrows
    public void registerStudent(RegisterStudentDTO registerStudentDTO)
    {
        if(studentRepository.findByFirstName(registerStudentDTO.getFirstName()).isPresent())
        {
            throw new StudentAlreadyExistException("exista deja studentul");
        }

        Student student=Student.builder()
                .firstName(registerStudentDTO.getFirstName())
                .lastName(registerStudentDTO.getLastName())
                .adress(registerStudentDTO.getAdress())
                .age(registerStudentDTO.getAge())
                .nrAbsente(registerStudentDTO.getNrAbsente())
                .medie(registerStudentDTO.getMedie())
                .clasa(registerStudentDTO.getClasa()).build();


        studentRepository.save(student);


        serializationStudent(student);

        //System.out.println(deserializationStudent());

    }


    @SneakyThrows
    public void putStudent(Long studentId,RegisterStudentDTO newRegisterStudentDTO)
    {
        Student student = studentRepository.findById(studentId).orElseThrow(()->new StudentNotFoundException("student not found"));

        if(newRegisterStudentDTO.getFirstName()!=null)
        student.setFirstName(newRegisterStudentDTO.getFirstName());

        if(newRegisterStudentDTO.getLastName()!=null)
        student.setLastName(newRegisterStudentDTO.getLastName());

        if(newRegisterStudentDTO.getAdress()!=null)
        student.setAdress(newRegisterStudentDTO.getAdress());

        if(newRegisterStudentDTO.getAge()!=null)
        student.setAge(newRegisterStudentDTO.getAge());

        if(newRegisterStudentDTO.getNrAbsente()!=null)
        student.setNrAbsente(newRegisterStudentDTO.getNrAbsente());

        if(newRegisterStudentDTO.getMedie()!=null)
        student.setMedie(newRegisterStudentDTO.getMedie());

        if(newRegisterStudentDTO.getClasa()!=null)
        student.setClasa(newRegisterStudentDTO.getClasa());

        studentRepository.save(student);


    }



    @SneakyThrows
    public void removeStudent(Long studentId)
    {
        Student student = studentRepository.findById(studentId).orElseThrow(()->new StudentNotFoundException("student not found"));
        studentRepository.deleteById(studentId);
    }


    @SneakyThrows
    public void removeAllStudents()
    {
        studentRepository.deleteAll();
    }


    @SneakyThrows
    public GetStudentDTO getStudent(Long studentId)
    {

        Student student = studentRepository.findById(studentId).orElseThrow(()->new StudentNotFoundException("student not found"));

        GetStudentDTO getStudentDTO= GetStudentDTO.builder()
                .firstName(student.getFirstName())
                .lastName(student.getLastName())
                .medie(student.getMedie())
                .clasa(student.getClasa())
                .nrAbsente(student.getNrAbsente()).build();

        return getStudentDTO;
    }

    public void serializationStudent(Student student) {


        try (ObjectOutputStream fout = new ObjectOutputStream(new FileOutputStream("school-class-management/src/main/java/com/example/school_class_management/ex_4/Student.txt"))) {
            fout.writeObject(student);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SneakyThrows
    public Student deserializationStudent()
    {
        Student student;

        ObjectInputStream fin = new ObjectInputStream(new FileInputStream("school-class-management/src/main/java/com/example/school_class_management/ex_4/Student.txt"));

        student =(Student)fin.readObject();

        return student;

    }

}
