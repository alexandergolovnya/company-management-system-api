package com.universityspa.repository.auth;

import com.universityspa.entity.auth.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

/**
 * Implementation of JpaRepository for Token entity
 */

public interface TokenRepository extends JpaRepository<Token, Long> {

    /**
     * Method returns one token by its token
     * @param token token of a token
     * @return Token
     */
    Optional<Token> findOneByToken(String token);

    @Query("SELECT t FROM Token t WHERE t.id=:id")
    Token getOne(@Param("id") Long id);
}
