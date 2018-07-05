package com.aleksgolovnya.deansoffice.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/** Сущность "Факультет" */

@Data

@Entity
public class Faculty {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /** Название факультета */
    @Column
    private String name;

    /** Описание факультета */
    @Column
    private String description;

    @Column
    private Long departmentId;

//    /** Список кафедр данного факультета */
//    @OneToMany(mappedBy = "faculty")
//    private Set<Department> departmentList = new HashSet<>();

    public Faculty(String name, String description) {
        this.name = name;
        this.description = description;
    }
}

