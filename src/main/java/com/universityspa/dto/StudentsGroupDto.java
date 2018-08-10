package com.universityspa.dto;

import lombok.Data;

/**
 * DTO class for entity @link StudentsGroup
 */

@Data
public class StudentsGroupDto {

    private Long id;

    /**
     * Name of the student group
     */
    private String groupName;

    /**
     * Specialty for this student group
     */
    private Long specialtyId;
}
