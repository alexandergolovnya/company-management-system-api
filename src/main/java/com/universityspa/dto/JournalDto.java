package com.universityspa.dto;

import com.universityspa.entity.Department;
import com.universityspa.entity.Journal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * DTO class for entity @link Journal
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JournalDto {

    private Long id;

    /**
     * Id af a schedule item for the record of this journal
     */
    private Long scheduleId;

    /**
     * Student in the journal
     */
    private Long studentId;


    /**
     * Mark for the student in the journal
     * on the subject on some date
     *
     * Capable of taking values: null, 'н',
     * numbers from 1 to 5
     */
    private String mark;

    /**
     * Method converts entity to dto
     * @param entity
     * @return dto
     */
    public static JournalDto convertFromEntityToDTO(Journal entity) {
        return JournalDto.builder()
                .id(entity.getId())
                .scheduleId(entity.getScheduleId())
                .studentId(entity.getStudentId())
                .mark(entity.getMark())
                .build();
    }
}
