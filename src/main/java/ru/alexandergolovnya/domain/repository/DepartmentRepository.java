package ru.alexandergolovnya.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.alexandergolovnya.domain.entity.company.Department;

/**
 * Implementation of JpaRepository for Department entity
 *
 * @author: Alexander Golovnya <mail@alexandergolovnya.ru>
 * @created: 2019/09/04
 */
public interface DepartmentRepository extends JpaRepository<Department, Integer> {
}
