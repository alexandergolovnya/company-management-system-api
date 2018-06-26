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
    private int id;

    /* Преподаватель */
    @OneToMany(mappedBy = "teacher_schedule")
    private Teacher teacher_schedule;

    /* Предметы */
    @OneToMany(mappedBy = "subjects_schedule")
    private Subject subjects_schedule;

    /* Студенты */
    @OneToMany(mappedBy = "students_schedule")
    private Student students_schedule;
}
