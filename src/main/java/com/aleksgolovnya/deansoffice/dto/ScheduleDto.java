package com.aleksgolovnya.deansoffice.dto;

import lombok.Data;

/**
 * DTO class for entity @link Schedule
 */

@Data
public class ScheduleDto {

    private Long id;

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
