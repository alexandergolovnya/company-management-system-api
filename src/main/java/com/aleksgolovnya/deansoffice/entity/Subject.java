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
    @ManyToMany
    @JoinTable(
            name = "teachers_subjects",
            joinColumns = { @JoinColumn(name = "subjectId", insertable = false, updatable = false) },
            inverseJoinColumns = { @JoinColumn(name = "teacherId", insertable = false, updatable = false) }
    )
    List<Teacher> teachers;

//    /** Расписание для данных предметов */
//    @OneToMany(mappedBy = "subject")
//    private List<Schedule> scheduleList;
}

