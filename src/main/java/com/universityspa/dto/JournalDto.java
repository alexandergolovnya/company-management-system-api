package com.universityspa.dto;

import lombok.Data;
import java.util.Date;

/**
 * DTO class for entity @link Journal
 */

@Data
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
}
