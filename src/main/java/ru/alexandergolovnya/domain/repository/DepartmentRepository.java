package ru.alexandergolovnya.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.alexandergolovnya.domain.entity.company.Department;

/**
 * Implementation of JpaRepository for Department entity
 */
public interface DepartmentRepository extends JpaRepository<Department, Integer> {
}
