package com.universityspa.dto;

import com.universityspa.entity.Schedule;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * DTO class for entity @link Schedule
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
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

    /**
     * Method converts entity to dto
     * @param entity
     * @return dto
     */
    public static ScheduleDto convertFromEntityToDTO(Schedule entity) {
        return ScheduleDto.builder()
                .id(entity.getId())
                .date(entity.getDate())
                .classNumber(entity.getClassNumber())
                .subjectId(entity.getSubjectId())
                .teacherId(entity.getTeacherId())
                .studentsGroupId(entity.getStudentsGroupId())
                .build();
    }
}
