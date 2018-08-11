package com.universityspa.dto;

import lombok.Data;

/**
 * DTO class for entity @link Department
 */

@Data
public class DepartmentDto {

    private Long id;

    /**
     * Name of this department
     */
    private String name;

    /**
     * Description of this department
     */
    private String description;

    /**
     * Faculty of this department
     */
    private Long facultyId;
}
