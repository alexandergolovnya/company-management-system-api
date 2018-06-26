package com.aleksgolovnya.deansoffice.entity;

import lombok.Data;
import javax.persistence.*;
import java.util.List;

/** Сущность "Студент" */

@Data

@Entity
@Table(name = "students", schema = "public")
public class Student {

    @Id
    @GeneratedValue
    private int student_id;

    /* Имя */
    @Column(name = "first_name")
    private int firstName;

    /* Фамилия */
    @Column(name = "last_name")
    private int lastName;

    /* Специализация */
    @Column(name = "specialization")
    private String specialization;

    /* Направление */
    @Column(name = "course")
    private String course;

    /* Успеваемость - средний бал */
    @Column(name = "average_score")
    private int averageScore;

    /* Посещаемость */
    @Column(name = "attendance")
    private int attendance;

    /* Список предметов, которые изучают студенты */
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "students_subjects",
            joinColumns = { @JoinColumn(name = "student_id") },
            inverseJoinColumns = { @JoinColumn(name = "subject_id") }
    )
    List<Subject> students_subjects;

    /* Расписание для студентов */
    @ManyToOne
    @JoinColumn(name = "schedule_id")
    private Schedule students_schedule;
}

