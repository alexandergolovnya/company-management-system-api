package com.universityspa.repository;

import com.universityspa.entity.Department;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Implementation of JpaRepository for Department entity
 */

public interface DepartmentRepository extends JpaRepository<Department, Long> {

    /**
     * Select all departments for faculty
     *
     * @param id of the faculty
     * @return List<Department>
     */
    @Query("SELECT d FROM Department d WHERE d.facultyId=:id")
    Page<Department> getFacultyDepartments(@Param("id") Long id, Pageable pageable);

    @Query("SELECT d FROM Department d WHERE d.id=:id")
    Department getOne(@Param("id") Long id);
}
