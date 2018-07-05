package com.aleksgolovnya.deansoffice.repository;

import com.aleksgolovnya.deansoffice.entity.StudentsGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentsGroupRepository extends JpaRepository<StudentsGroup, Long> {

    StudentsGroup getById(Long id);
}
