package com.example.school_class_management.ex_4.repository;

import com.example.school_class_management.ex_4.models.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfesorRepository extends JpaRepository<Profesor,Long> {

    Optional<Profesor> findById(Long id);

    Optional<Profesor>findByFirstName(String firstName);

}
