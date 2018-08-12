package com.universityspa.repository;

import com.universityspa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Implementation of JpaRepository for Student entity
 */

public interface StudentRepository extends JpaRepository<Student, Long> {
}
