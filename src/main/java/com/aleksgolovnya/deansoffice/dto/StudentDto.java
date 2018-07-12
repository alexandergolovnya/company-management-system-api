package com.aleksgolovnya.deansoffice.dto;

import lombok.Data;

/**
 * DTO class for entity @link Student
 */

@Data
public class StudentDto {

    private Long id;

    /**
     * First name of the student
     */
    private String firstName;

    /**
     * Last name of the student
     */
    private String lastName;

    /**
     * Number of the course on which
     * student is studying
     */
    private int course;

    /**
     * Student group to which the
     * student belongs
     */
    private Long groupId;
}
