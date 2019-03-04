package com.universityspa.repository.auth;

import com.universityspa.entity.auth.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

/**
 * Implementation of JpaRepository for User entity
 */

public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * Methods returns on user by email
     * @param email of the user
     * @return User
     */
    Optional<User> findOneByEmail(String email);

    /**
     * Select all teeachers for this department
     *
     * @param id of the department
     * @return list of teachers from department by id
     */
    Page<User> findAllByDepartmentId(@Param("id") Long id, Pageable pageable);

    /**
     * Select all students of student group
     *
     * @param id of the student group
     * @return list of students from student group by id
     */
    Page<User> findAllByStudentGroupId(@Param("id") Long id, Pageable pageable);

    @Query("SELECT u FROM User u WHERE u.id=:id")
    User getOne(@Param("id") Long id);
}
