package com.aleksgolovnya.deansoffice.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/** Расписание */

@Data

@Entity
public class Schedule {

    @Id
    @GeneratedValue
    private int schedule_id;

    /* Преподаватель */
    @OneToMany(mappedBy = "teacher_id")
    private List<Teacher> teachers;

    /* Предметы */
    @OneToMany(mappedBy = "subject_id")
    private List<Subject> subjects;

    /* Студенты */
    @OneToMany(mappedBy = "student_id")
    private List<Student> students;
}


