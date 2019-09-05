package ru.alexandergolovnya.domain.dto;

import lombok.Data;

/**
 * @author: Alexander Golovnya <mail@alexandergolovnya.ru>
 * @created: 2019/09/04
 */
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
