package ru.alexandergolovnya.domain.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import ru.alexandergolovnya.domain.entity.user.User;

import java.util.Optional;

/**
 * Implementation of JpaRepository for User entity
 *
 * @author: Alexander Golovnya <mail@alexandergolovnya.ru>
 * @created: 2019/09/04
 */
public interface UserRepository extends JpaRepository<User, Integer> {

    /**
     * Methods returns on user by email
     * @param email of the user
     * @return User
     */
    Optional<User> findOneByEmail(String email);

    /**
     * Select all employees for this department
     *
     * @param id of the department
     * @return list of teachers from department by id
     */
    Page<User> findAllByDepartmentId(@Param("id") int id, Pageable pageable);
}
