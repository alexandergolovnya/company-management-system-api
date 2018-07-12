package com.aleksgolovnya.deansoffice.dto;

import lombok.Data;

/**
 * DTO class for entity @link Specialty
 */

@Data
public class SpecialtyDto {

    private Long id;

    /**
     * Name of the speciality
     */
    private String name;

    /**
     * Description of the speciality
     */
    private String description;

    /**
     * Department of this speciality
     */
    private Long departmentId;

}
