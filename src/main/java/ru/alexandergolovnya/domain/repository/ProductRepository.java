package ru.alexandergolovnya.domain.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import ru.alexandergolovnya.domain.entity.sales.Product;

/**
 * Implementation of JpaRepository for Product entity
 *
 * @author: Alexander Golovnya <mail@alexandergolovnya.ru>
 * @created: 2019/09/04
 */
public interface ProductRepository extends JpaRepository<Product, Integer> {

	/**
	 * Select all products for this product category
	 *
	 * @param id of the product
	 * @return list of products from product category by id
	 */
	Page<Product> findAllByProductCategoryId(@Param("id") int id, Pageable pageable);

	/**
	 * Select all products for this order
	 *
	 * @param id of the product
	 * @return list of products from order by id
	 */
	Page<Product> findAllByOrderId(@Param("id") int id, Pageable pageable);
}
