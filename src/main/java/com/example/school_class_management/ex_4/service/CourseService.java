package com.example.school_class_management.ex_4.service;

import com.example.school_class_management.ex_4.dtos.GetCourseDTO;
import com.example.school_class_management.ex_4.dtos.RegisterCourseDTO;
import com.example.school_class_management.ex_4.exceptions.CourseAlreadyExistException;
import com.example.school_class_management.ex_4.exceptions.CourseNotFoundException;
import com.example.school_class_management.ex_4.models.Course;
import com.example.school_class_management.ex_4.repository.CourseRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;

@Service
public class CourseService {

    private CourseRepository courseRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }


    @SneakyThrows
    public void registerCourse(RegisterCourseDTO registerCourseDTO)
    {
        if(courseRepository.findByCourseName(registerCourseDTO.getCourseName()).isPresent())
        {
            throw new CourseAlreadyExistException("Course already exist");
        }

        Course course=Course.builder()
                .courseName(registerCourseDTO.getCourseName())
                .professorName(registerCourseDTO.getProfessorName())
                .numberOfStudents(registerCourseDTO.getNumberOfStudents()).build();

        courseRepository.save(course);

        serializationCourse(course);

        //System.out.println(deserializationCourse());

    }


    @SneakyThrows
    public void putCourse(Long courseId,RegisterCourseDTO newRegisterCourseDTO)
    {
        Course course = courseRepository.findById(courseId).orElseThrow(()->new CourseNotFoundException("course not found"));

        if(newRegisterCourseDTO.getCourseName()!=null)
            course.setCourseName(newRegisterCourseDTO.getCourseName());

        if(newRegisterCourseDTO.getProfessorName()!=null)
            course.setProfessorName(newRegisterCourseDTO.getProfessorName());

        if(newRegisterCourseDTO.getNumberOfStudents()!=null)
            course.setNumberOfStudents(newRegisterCourseDTO.getNumberOfStudents());

        courseRepository.save(course);


    }

    @SneakyThrows
    public void removeCourse(Long courseId)
    {
        Course course = courseRepository.findById(courseId).orElseThrow(()->new CourseNotFoundException("course not found"));
        courseRepository.delete(course);
    }


    public void removeAllCourses()
    {
        courseRepository.deleteAll();
    }

    @SneakyThrows
    public GetCourseDTO getCourse(Long courseId)
    {
        Course course = courseRepository.findById(courseId).orElseThrow(()->new CourseNotFoundException("course not found"));

        GetCourseDTO getCourseDTO = GetCourseDTO.builder()
                .courseName(course.getCourseName())
                .numberOfStudents(course.getNumberOfStudents()).build();

        return getCourseDTO;



    }

    public void serializationCourse(Course course) {


        try (ObjectOutputStream fout = new ObjectOutputStream(new FileOutputStream("school-class-management/src/main/java/com/example/school_class_management/ex_4/Course.txt"))) {
            fout.writeObject(course);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SneakyThrows
    public Course deserializationCourse()
    {
        Course course;

        ObjectInputStream fin = new ObjectInputStream(new FileInputStream("school-class-management/src/main/java/com/example/school_class_management/ex_4/Course.txt"));

            course =(Course)fin.readObject();

        return course;

    }
}
