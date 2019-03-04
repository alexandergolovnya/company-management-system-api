package com.universityspa.repository;

import com.universityspa.entity.StudentsGroup;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Implementation of JpaRepository for Student Group entity
 */


public interface StudentsGroupRepository extends JpaRepository<StudentsGroup, Long> {

    /**
     * Select all student groups for this specialty
     *
     * @param id of the specialty
     * @return List<StudentsGroup>
     */
    @Query("SELECT g FROM StudentsGroup g WHERE g.specialtyId=:id")
    Page<StudentsGroup> getSpecialtyStudentGroups(@Param("id") Long id, Pageable pageable);

    @Query("SELECT s FROM StudentsGroup s WHERE s.id=:id")
    StudentsGroup getOne(@Param("id") Long id);
}
