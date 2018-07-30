package com.aleksgolovnya.deansoffice.dto;

import lombok.Data;

import java.util.Date;

/**
 * DTO class for entity @link Schedule
 */

@Data
public class ScheduleDto {

    private Long id;

    /**
     * Date of the lesson
     */
    private Date date;

    /**
     * Number of the class in the schedule
     */
    private int classNumber;

    /**
     * Subject in the schedule
     */
    private Long subjectId;

    /**
     * Teacher for the subject
     */
    private Long teacherId;

    /**
     * Student group that studies subject
     */
    private Long studentsGroupId;
}
