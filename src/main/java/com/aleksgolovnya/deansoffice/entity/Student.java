package com.aleksgolovnya.deansoffice.entity;

import lombok.Data;
import javax.persistence.*;
import java.util.List;

/** Сущность "Студент" */

@Data

@Entity
public class Student {

    @Id
    @GeneratedValue
    private int student_id;

    /* Имя */
    @Column(name = "first_name")
    private String firstName;

    /* Фамилия */
    @Column(name = "last_name")
    private String lastName;

    /* Специальность */
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "specialty_id")
    private Specialty specialty;

    /* Курс обучения */
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
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "schedule_id")
    private Schedule schedule;
}

