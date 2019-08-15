package ru.alexandergolovnya.domain.dto;

import lombok.Data;

@Data
public class ProductDto {

	private int id;

	private String name;

	private String description;

	private String photo;

	private double price;

	private int productCategoryId;

	private int orderId;
}
