package com.universityspa.repository;

import com.universityspa.entity.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Implementation of JpaRepository for Faculty entity
 */

public interface FacultyRepository extends JpaRepository<Faculty, Long> {
}
