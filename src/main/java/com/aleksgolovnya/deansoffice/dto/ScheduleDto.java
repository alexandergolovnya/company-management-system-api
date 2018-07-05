package com.aleksgolovnya.deansoffice.dto;

import com.aleksgolovnya.deansoffice.entity.Schedule;
import lombok.Data;

@Data

public class ScheduleDto {
    private Long id;
    private Long subjectId;
    private Long teacherId;
    private Long studentsGroupId;

    public ScheduleDto(Schedule schedule) {}
}
