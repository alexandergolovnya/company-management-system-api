package com.aleksgolovnya.deansoffice.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * Entity class for Schedule
 */

@Data

@Entity
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Date of the lesson
     */
    @Column
    private Date date;

    /**
     * Number of the class in the schedule
     */
    @Column
    private int classNumber;

    /**
     * Id of a subject in the schedule
     */
    @Column
    private Long subjectId;

    /**
     * Id of a  teacher for the subject
     */
    @Column
    private Long teacherId;

    /**
     * Id of a student group that studies subject
     */
    @Column
    private Long studentsGroupId;

    /**
     * Subject in the schedule
     */
    @ManyToOne
    @JoinColumn(name = "subjectId", insertable = false, updatable = false)
    private Subject subject;

    /**
     * Teacher for the subject
     */
    @ManyToOne
    @JoinColumn(name = "teacherId", insertable = false, updatable = false)
    private Teacher teacher;

    /**
     * Student group that studies subject
     */
    @ManyToOne
    @JoinColumn(name = "studentsGroupId", insertable = false, updatable = false)
    private StudentsGroup studentsGroup;
}


