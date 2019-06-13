package ru.alexandergolovnya.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.alexandergolovnya.domain.entity.user.Token;

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
}
