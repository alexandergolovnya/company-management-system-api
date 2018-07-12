package com.aleksgolovnya.deansoffice.dto;

import lombok.Data;

/**
 * DTO class for entity @link Subject
 */

@Data
public class TeacherDto {

    private Long id;

    /**
     * First name of the teacher
     */
    private String firstName;

    /**
     * Last name of the teacher
     */
    private String lastName;

    /**
     * Position of the teacher
     */
    private String position;

    /**
     * Department to which teacher belongs
     */
    private Long departmentId;
}
