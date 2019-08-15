package ru.alexandergolovnya.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.alexandergolovnya.domain.entity.sales.ProductCategory;

/**
 * Implementation of JpaRepository for ProductCategory entity
 */

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer> {
}
