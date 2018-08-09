package com.aleksgolovnya.deansoffice.repository.auth;

import com.aleksgolovnya.deansoffice.entity.auth.Token;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Repository for Token entity
 */
public interface TokenRepository extends JpaRepository<Token, Long> {

    /**
     * Method returns one token by its value
     * @param value of token
     * @return Token
     */
    Optional<Token> findOneByValue(String value);
}
