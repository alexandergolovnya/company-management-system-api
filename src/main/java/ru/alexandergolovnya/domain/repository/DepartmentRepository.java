package ru.alexandergolovnya.domain.repository;

import ru.alexandergolovnya.domain.entity.company.Department;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Implementation of JpaRepository for Department entity
 */

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

//    @Query("SELECT d FROM Department d WHERE d.id=:id")
//    Department getOne(@Param("id") Long id);
}
