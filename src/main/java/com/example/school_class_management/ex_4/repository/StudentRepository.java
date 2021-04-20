package com.example.school_class_management.ex_4.repository;

import com.example.school_class_management.ex_4.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

    Optional<Student>findByFirstName(String firstName);

    Optional<Student>findById(Long id);



}
