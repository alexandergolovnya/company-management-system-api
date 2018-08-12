package com.universityspa.repository;

import com.universityspa.entity.Specialty;
import com.universityspa.entity.StudentsGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Implementation of JpaRepository for Specialty entity
 */

public interface SpecialtyRepository extends JpaRepository<Specialty, Long> {

    /**
     * Select all student groups for this specialty
     *
     * @param id of the specialty
     * @return List<StudentsGroup>
     */
    @Query("SELECT g FROM StudentsGroup g WHERE g.specialtyId=:id")
    List<StudentsGroup> getSpecialtyStudentGroups(@Param("id") Long id);
}
