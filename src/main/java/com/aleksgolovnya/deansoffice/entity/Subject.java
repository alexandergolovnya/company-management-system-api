package com.aleksgolovnya.deansoffice.entity;

import lombok.Data;
import javax.persistence.*;
import java.util.List;

/** Сущность "Предмет" */

@Data

@Entity
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Название предмета */
    @Column
    private String name;

    /** Описание предмета */
    @Column(length = 4096)
    private String description;

    /** Преподаватели данного предмета */
    @ManyToMany
    @JoinTable(
            name = "teachers_subjects",
            joinColumns = { @JoinColumn(name = "subjectId", insertable = false, updatable = false) },
            inverseJoinColumns = { @JoinColumn(name = "teacherId", insertable = false, updatable = false) }
    )
    List<Teacher> teachers;
}

