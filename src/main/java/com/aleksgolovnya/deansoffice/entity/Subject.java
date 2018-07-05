package com.aleksgolovnya.deansoffice.entity;

import lombok.Data;
import javax.persistence.*;
import java.util.List;

/** Сущность "Предмет" */

@Data

@Entity
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /** Название предмета */
    @Column
    private String name;

    /** Описание предмета */
    @Column
    private String description;

//    /** Специальности, на которой изучают данный предмет */
//    @ManyToMany(mappedBy = "specialties_subjects")
//    private List<Specialty> specialties;

    /** Преподаватели данного предмета */
    @ManyToMany(mappedBy = "teachers_subjects")
    private List<Teacher> teachers;

//    /** Расписание для данных предметов */
//    @OneToMany(mappedBy = "subject")
//    private List<Schedule> scheduleList;

    public Subject(String name, String description) {
        this.name = name;
        this.description = description;
    }
}

