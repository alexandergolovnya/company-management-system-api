package com.universityspa.repository.auth;

import com.universityspa.entity.auth.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Repository for User entity
 */
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * Methods returns on user by email
     * @param email of the user
     * @return User
     */
    Optional<User> findOneByEmail(String email);
}
