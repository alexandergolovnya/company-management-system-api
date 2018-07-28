package com.aleksgolovnya.deansoffice.repository;

import com.aleksgolovnya.deansoffice.entity.Department;
import com.aleksgolovnya.deansoffice.entity.Specialty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

    Department getById(Long id);

    /** Получить все специальности данной кафедры */
    @Query("SELECT s FROM Specialty s WHERE s.departmentId=:id")
    List<Specialty> getDepartmentSpecialties(@Param("id") Long id);
}
