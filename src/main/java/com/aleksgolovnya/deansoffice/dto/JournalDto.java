package com.aleksgolovnya.deansoffice.dto;

import lombok.Data;
import java.util.Date;

/**
 * DTO class for entity @link Journal
 */

@Data
public class JournalDto {

    private Long id;

    /**
     * Subject in the journal
     */
    private Long subjectId;

    /**
     * Student in the journal
     */
    private Long studentId;

    /**
     * Date of the record in the journal
     */
    private Date date;

    /**
     * Mark for the student in the journal
     * on the subject on some date
     *
     * Capable of taking values: null, 'н',
     * numbers from 1 to 5
     */
    private String mark;
}
