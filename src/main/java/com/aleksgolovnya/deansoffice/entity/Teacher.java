package com.aleksgolovnya.deansoffice.entity;

import lombok.Data;

import javax.persistence.*;

/** Сущность "Преподаватель" */

@Data

@Entity
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Имя */
    @Column
    private String firstName;

    /** Фамилия */
    @Column
    private String lastName;

    /** Должность */
    @Column
    private String position;

    @Column
    private Long departmentId;

    /** Кафедра преподавателя */
    @ManyToOne
    @JoinColumn(name = "departmentId", insertable = false, updatable = false)
    private Department department;

//    /** Расписание для данного преподавателя */
//    @OneToMany(mappedBy = "teacher")
//    private List<Schedule> schedules;

//    /** Список предметов для данного преподавателя */
//    @ManyToMany(mappedBy = "teachers_subjects")
//    private List<Subject> teachers;
}
