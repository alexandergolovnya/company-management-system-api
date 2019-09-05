package ru.alexandergolovnya.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.alexandergolovnya.domain.entity.sales.ProductCategory;

/**
 * Implementation of JpaRepository for ProductCategory entity
 *
 * @author: Alexander Golovnya <mail@alexandergolovnya.ru>
 * @created: 2019/09/04
 */
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer> {
}
