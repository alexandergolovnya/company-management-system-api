package ru.alexandergolovnya.service.sales;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import ru.alexandergolovnya.domain.dto.ProductDto;
import ru.alexandergolovnya.exception.NotFoundException;

/**
 * @author: Alexander Golovnya <mail@alexandergolovnya.ru>
 * @created: 2019/09/04
 */
public interface ProductService {

	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_SALES_MANAGER')")
	ProductDto addProduct(ProductDto productDto);

	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_SALES_MANAGER')")
	void deleteProduct(int id) throws NotFoundException;

	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_SALES_MANAGER')")
	ProductDto editProduct(int id, ProductDto productDto) throws NotFoundException;

	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_USER', 'ROLE_SALES_MANAGER')")
	Page<ProductDto> getAll(Pageable pageable);

	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_USER', 'ROLE_SALES_MANAGER')")
	Page<ProductDto> getAllByProductCategoryId(int id, Pageable pageable);

	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_USER', 'ROLE_SALES_MANAGER')")
	Page<ProductDto> getAllByOrderId(int id, Pageable pageable);

	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_USER', 'ROLE_SALES_MANAGER')")
	ProductDto getById(int id) throws NotFoundException;
}
