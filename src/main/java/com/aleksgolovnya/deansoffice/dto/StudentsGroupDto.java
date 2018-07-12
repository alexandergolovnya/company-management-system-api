package com.aleksgolovnya.deansoffice.dto;

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
}
