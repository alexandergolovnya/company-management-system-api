package ru.alexandergolovnya.domain.dto;

import lombok.Data;

/**
 * @author: Alexander Golovnya <mail@alexandergolovnya.ru>
 * @created: 2019/09/04
 */
@Data
public class OrderDto {

    private int id;

    private String orderCategory;

    private String orderDescription;

    private String status;

    private String customerName;

    private String customerEmail;

    private String managerEmail;
}
