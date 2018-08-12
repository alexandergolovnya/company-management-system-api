package com.universityspa.repository;

import com.universityspa.entity.Department;
import com.universityspa.entity.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Implementation of JpaRepository for Faculty entity
 */

public interface FacultyRepository extends JpaRepository<Faculty, Long> {

    Faculty getById(Long id);

    /**
     * Select all departments for this faculty
     *
     * @param id of the faculty
     * @return List<Department>
     */
    @Query("SELECT d FROM Department d WHERE d.facultyId=:id")
    List<Department> getFacultyDepartments(@Param("id") Long id);
}
