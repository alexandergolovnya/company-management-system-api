package com.universityspa.repository;

import com.universityspa.entity.Teacher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Implementation of JpaRepository for Teacher entity
 */

public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    /**
     * Select all teeachers for this department
     *
     * @param id of ht department
     * @return List<Teacher>
     */
    @Query("SELECT t FROM Teacher t WHERE t.departmentId=:id")
    Page<Teacher> getDepartmentTeachers(@Param("id") Long id, Pageable pageable);
}
