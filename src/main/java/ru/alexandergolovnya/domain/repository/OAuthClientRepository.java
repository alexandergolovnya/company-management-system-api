package ru.alexandergolovnya.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.alexandergolovnya.domain.entity.OAuthClient;

import java.util.Optional;

/**
 * @author: Alexander Golovnya <mail@alexandergolovnya.ru>
 * @created: 2019/09/10
 */
@Repository
public interface OAuthClientRepository extends JpaRepository<OAuthClient, Integer> {

    Optional<OAuthClient> findByClientId(String clientId);
}
