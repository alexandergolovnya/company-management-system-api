package com.aleksgolovnya.deansoffice.entity;

import lombok.Data;

import javax.persistence.*;

/** Сущность "Кафедра" */

@Data

@Entity
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Название кафедры */
    @Column
    private String name;

    /** Описание кафедры */
    @Column(length = 4096)
    private String description;

    @Column
    private Long facultyId;

    /** Факультет к которому относится кафедра */
    @ManyToOne
    @JoinColumn(name = "facultyId", insertable = false, updatable = false)
    private Faculty faculty;

//    public Department(String name, String description) {
//        this.name = name;
//        this.description = description;
//    }
}