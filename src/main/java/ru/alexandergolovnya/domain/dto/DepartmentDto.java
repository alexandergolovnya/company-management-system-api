package ru.alexandergolovnya.domain.dto;

import lombok.Data;

/**
 * DTO class for entity @link Department
 *
 * @author: Alexander Golovnya <mail@alexandergolovnya.ru>
 * @created: 2019/09/04
 */
@Data
public class DepartmentDto {

    private int id;

    /**
     * Name of this department
     */
    private String name;

    /**
     * Description of this department
     */
    private String description;
}
