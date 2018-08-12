package com.universityspa.repository;

import com.universityspa.entity.Department;
import com.universityspa.entity.Specialty;
import com.universityspa.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Implementation of JpaRepository for Department entity
 */

public interface DepartmentRepository extends JpaRepository<Department, Long> {

    /**
     * Select all specialties for this department
     *
     * @param id of ht department
     * @return List<Specialty>
     */
    @Query("SELECT s FROM Specialty s WHERE s.departmentId=:id")
    List<Specialty> getDepartmentSpecialties(@Param("id") Long id);

    /**
     * Select all teeachers for this department
     *
     * @param id of ht department
     * @return List<Teacher>
     */
    @Query("SELECT t FROM Teacher t WHERE t.departmentId=:id")
    List<Teacher> getDepartmentTeachers(@Param("id") Long id);
}
