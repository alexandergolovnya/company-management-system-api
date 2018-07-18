package com.aleksgolovnya.deansoffice.repository;

import com.aleksgolovnya.deansoffice.entity.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:8081")
public interface FacultyRepository extends JpaRepository<Faculty, Long> {

    Faculty getById(Long id);
}
