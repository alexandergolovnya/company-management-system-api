package com.aleksgolovnya.deansoffice.dto;

import lombok.Data;

/**
 * DTO class for entity @link Facult
 */

@Data
public class FacultyDto {

    private Long id;

    /**
     * Name of this faculty
     */
    private String name;

    /**
     * Description of this faculty
     */
    private String description;
}
