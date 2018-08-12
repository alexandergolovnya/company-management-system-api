package com.universityspa.repository;

import com.universityspa.entity.Specialty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Implementation of JpaRepository for Specialty entity
 */

public interface SpecialtyRepository extends JpaRepository<Specialty, Long> {

    /**
     * Select all specialties for this department
     *
     * @param id of ht department
     * @return List<Specialty>
     */
    @Query("SELECT s FROM Specialty s WHERE s.departmentId=:id")
    List<Specialty> getDepartmentSpecialties(@Param("id") Long id);
}
