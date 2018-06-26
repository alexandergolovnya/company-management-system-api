package com.aleksgolovnya.deansoffice.entity;

import lombok.Data;
import javax.persistence.*;
import java.util.List;

/** Сущность "Предмет" */

@Data

@Entity
public class Subject {

    @Id
    @GeneratedValue
    private int subject_id;

    /* Название предмета */
    @Column(name = "name")
    private String name;

    /* Описание предмета */
    @Column(name = "description")
    private String description;

    /* Количество часов в неделю */
    @Column(name = "hours_per_week")
    private int hoursPerWeek;

    /* Специальности, на которой изучают данный предмет */
    @ManyToMany(mappedBy = "specialties_subjects")
    private List<Specialty> specialties;

    /* Преподаватели данного предмета */
    @ManyToMany(mappedBy = "teachers_subjects")
    private List<Teacher> teachers;

    /* Расписание для данных предметов */
    @ManyToOne
    @JoinColumn(name = "subjects_id")
    private Schedule schedule;

    /* Студенты, которые изучают данный предмет */
    @ManyToMany(mappedBy = "students_subjects")
    private List<Student> students;
}

