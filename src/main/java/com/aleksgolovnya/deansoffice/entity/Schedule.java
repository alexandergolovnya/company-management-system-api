package com.aleksgolovnya.deansoffice.entity;

import lombok.Data;

import javax.persistence.*;

/** Расписание */

@Data

@Entity
@Table(name = "schedules", schema = "public")
public class Schedule {

    @Id
    @GeneratedValue
    private int schedule_id;

    /* Преподаватель */
    @OneToMany(mappedBy = "teacher_id")
    private Teacher teacher;

    /* Предметы */
    @OneToMany(mappedBy = "subject_id")
    private Subject subject;

    /* Студенты */
    @OneToMany(mappedBy = "student_id")
    private Student student;
}
