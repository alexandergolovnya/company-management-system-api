package ru.alexandergolovnya.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.alexandergolovnya.domain.entity.sales.Order;

/**
 * Implementation of JpaRepository for Order entity
 *
 * @author: Alexander Golovnya <mail@alexandergolovnya.ru>
 * @created: 2019/09/04
 */
public interface OrderRepository extends JpaRepository<Order, Integer> {
}
