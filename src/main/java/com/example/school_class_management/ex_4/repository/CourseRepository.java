package com.example.school_class_management.ex_4.repository;

import com.example.school_class_management.ex_4.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {
    Optional<Course> findByCourseName(String courseName);
}
