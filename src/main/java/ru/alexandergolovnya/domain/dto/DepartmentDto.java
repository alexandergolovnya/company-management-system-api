package ru.alexandergolovnya.domain.dto;

import lombok.Data;

/**
 * DTO class for entity @link Department
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
