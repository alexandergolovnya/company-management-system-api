package com.aleksgolovnya.deansoffice.entity;

import lombok.Data;
import javax.persistence.*;
import java.util.List;

/** Сущность "Специальность" */

@Data

@Entity
public class Specialty {

    @Id
    @GeneratedValue
    private int specialties_id;

    /* Название специальности */
    @Column(name = "name")
    private String name;

    /* Описание Специализации */
    @Column(name = "description")
    private String description;

    /* Кафедра для данного направления */
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    /* Студенты, обучающиеся на данной специальности */
    @OneToMany(mappedBy = "specialty")
    private List<Student> students;

    /* Список предметов, для данной специальности */
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "specialties_subjects",
            joinColumns = { @JoinColumn(name = "specialties_id") },
            inverseJoinColumns = { @JoinColumn(name = "subject_id") }
    )
    List<Subject> specialties_subjects;


}