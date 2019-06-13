package ru.alexandergolovnya.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.alexandergolovnya.domain.entity.sales.Order;

/**
 * Implementation of JpaRepository for Order entity
 */

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
