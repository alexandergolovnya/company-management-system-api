package com.universityspa.entity;

import com.universityspa.entity.auth.User;
import lombok.Data;

import javax.persistence.*;

/**
 * Entity class for Journal
 */

@Data
@Entity
public class Journal {

    @Id
    @GeneratedValue
    private Long id;

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
     * Id af a schedule item for the record of this journal
     */
    @Column
    private Long scheduleId;

    /**
     * Id af a student in the journal
     */
    @Column
    private Long studentId;

    /**
     * Schedule item for the record of this journal
     */
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "scheduleId", insertable = false, updatable = false)
    private Schedule schedule;

    /**
     * Student in the journal
     */
    @ManyToOne
    @JoinColumn(name = "userId", insertable = false, updatable = false)
    private User user;
}
