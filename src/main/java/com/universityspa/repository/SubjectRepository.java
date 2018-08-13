package com.universityspa.repository;

import com.universityspa.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Implementation of JpaRepository for Subject entity
 */

public interface SubjectRepository extends JpaRepository<Subject, Long> {
}
