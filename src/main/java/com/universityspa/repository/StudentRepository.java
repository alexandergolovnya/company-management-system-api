package com.universityspa.repository;

import com.universityspa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

    Student getById(Long id);
}
