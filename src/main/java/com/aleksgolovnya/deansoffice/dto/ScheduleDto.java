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
     * Students groups that studies subject
     */
    private Long studentsGroupId;
}
