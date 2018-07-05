package com.aleksgolovnya.deansoffice.entity;

import lombok.Data;

import javax.persistence.*;

/** Расписание */

@Data

@Entity
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private Long subjectId;

    @Column
    private Long teacherId;

    @Column
    private Long studentsGroupId;

    /** Предметы */
    @ManyToOne
    @JoinColumn(name = "subjectId", insertable = false, updatable = false)
    private Subject subject;

    /** Преподаватели */
    @ManyToOne
    @JoinColumn(name = "teacherId", insertable = false, updatable = false)
    private Teacher teacher;

    /** Преподаватели */
    @ManyToOne
    @JoinColumn(name = "studentsGroupId", insertable = false, updatable = false)
    private StudentsGroup studentsGroup;
}


