package ru.alexandergolovnya.service.sales;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.alexandergolovnya.domain.dto.ProductDto;
import ru.alexandergolovnya.domain.entity.sales.Product;
import ru.alexandergolovnya.domain.repository.ProductRepository;
import ru.alexandergolovnya.exception.NotFoundException;

import java.util.List;
import java.util.stream.Collectors;

import static ru.alexandergolovnya.utils.ObjectMapperUtils.map;

/**
 * @author: Alexander Golovnya <mail@alexandergolovnya.ru>
 * @created: 2019/09/04
 */
@Service
public class ProductServiceImpl implements ProductService {

	private final ProductRepository productRepository;

	public ProductServiceImpl(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Override
	public ProductDto addProduct(ProductDto productDto) {
		Product product = map(productDto, Product.class);
		Product savedProduct = productRepository.save(product);
		return map(savedProduct, ProductDto.class);
	}

	@Override
	public void deleteProduct(int id) throws NotFoundException {
		Product product = productRepository.getOne(id);
		if (product != null) {
			productRepository.delete(product);
		} else {
			throw new NotFoundException("Unable to delete, product with such id doesn't exist");
		}
	}

	@Override
	public ProductDto editProduct(int id, ProductDto productDto) throws NotFoundException {
		Product product = productRepository.getOne(id);
		if (product != null) {
			product = map(product, Product.class);
			Product savedProduct = productRepository.saveAndFlush(product);
			return map(savedProduct, ProductDto.class);
		} else {
			throw new NotFoundException("Unable to edit, product with such id doesn't exist");
		}
	}

	@Override
	public Page<ProductDto> getAll(Pageable pageable) {
		Page<Product> productPage = productRepository.findAll(pageable);
		int totalElements = (int) productPage.getTotalElements();
		List<ProductDto> productDtoList = productPage
				.getContent()
				.stream()
				.map(product ->  map(product, ProductDto.class))
				.collect(Collectors.toList());

		return new PageImpl<>(productDtoList, pageable, totalElements);
	}

	@Override
	public Page<ProductDto> getAllByProductCategoryId(int id, Pageable pageable) {
		Page<Product> productPage = productRepository.findAllByProductCategoryId(id, pageable);
		int totalElements = (int) productPage.getTotalElements();
		List<ProductDto> productDtoList = productPage
				.getContent()
				.stream()
				.map(product ->  map(product, ProductDto.class))
				.collect(Collectors.toList());

		return new PageImpl<>(productDtoList, pageable, totalElements);
	}

	@Override
	public Page<ProductDto> getAllByOrderId(int id, Pageable pageable) {
		Page<Product> productPage = productRepository.findAllByOrderId(id, pageable);
		int totalElements = (int) productPage.getTotalElements();
		List<ProductDto> productDtoList = productPage
				.getContent()
				.stream()
				.map(product ->  map(product, ProductDto.class))
				.collect(Collectors.toList());

		return new PageImpl<>(productDtoList, pageable, totalElements);
	}

	@Override
	public ProductDto getById(int id) throws NotFoundException {
		Product product = productRepository.getOne(id);
		if (product != null) {
			return map(product, ProductDto.class);
		} else {
			throw new NotFoundException("Product not found");
		}
	}
}
