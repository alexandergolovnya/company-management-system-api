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
    private Teacher teacher;

    /* Предметы */
    @OneToMany(mappedBy = "subjects_schedule")
    private Subject subject;

    /* Студенты */
    @OneToMany(mappedBy = "students_schedule")
    private Student student;
}
