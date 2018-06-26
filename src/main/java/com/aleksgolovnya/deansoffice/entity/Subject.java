package com.aleksgolovnya.deansoffice.entity;

import lombok.Data;
import javax.persistence.*;
import java.util.List;

/** Сущность "Предмет" */

@Data

@Entity
@Table(name = "subjects", schema = "public")
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

    /* Преподаватель данного предмета */
    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    /* Предметы представленные в расписании */
    @ManyToOne
    @JoinColumn(name = "subjects_id")
    private Schedule subjects_schedule;

    /* Студенты, которые изучают данный предмет */
    @ManyToMany(mappedBy = "students_subjects")
    private List<Student> students;

    /* Специальности, на которой изучают данный предмет */
    @ManyToMany(mappedBy = "specialties_subjects")
    private List<Specialty> specialties;

}
