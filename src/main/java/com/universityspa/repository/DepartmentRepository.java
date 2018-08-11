package com.universityspa.repository;

import com.universityspa.entity.Department;
import com.universityspa.entity.Specialty;
import com.universityspa.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

    Department getById(Long id);

    /** Получить все специальности данной кафедры */
    @Query("SELECT s FROM Specialty s WHERE s.departmentId=:id")
    List<Specialty> getDepartmentSpecialties(@Param("id") Long id);

    /** Получить всех преподавателей данной кафедры */
    @Query("SELECT t FROM Teacher t WHERE t.departmentId=:id")
    List<Teacher> getDepartmentTeachers(@Param("id") Long id);
}
