package com.aleksgolovnya.deansoffice.repository;

import com.aleksgolovnya.deansoffice.entity.Specialty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpecialtyRepository extends JpaRepository<Specialty, Long> {

    Specialty getById(Long id);
}
