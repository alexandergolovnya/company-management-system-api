package com.aleksgolovnya.deansoffice.entity;

import lombok.Data;
import javax.persistence.*;
import java.util.Date;

/**
 * Entity class for Journal
 */

@Data

@Entity
public class Journal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Id af a subject in the journal
     */
    @Column
    private Long subjectId;

    /**
     * Id af a student in the journal
     */
    @Column
    private Long studentId;

    /**
     * Date of the record in the journal
     */
    @Column
    private Date date;

    /**
     * Mark for the student in the journal
     * on the subject on some date
     *
     * Capable of taking values: null, 'н',
     * numbers from 1 to 5
     */
    @Column
    private String mark;

    /**
     * Subject in the journal
     */
    @ManyToOne
    @JoinColumn(name = "subjectId", insertable = false, updatable = false)
    private Subject subject;

    /**
     * Student in the journal
     */
    @ManyToOne
    @JoinColumn(name = "studentId", insertable = false, updatable = false)
    private Student student;
}
