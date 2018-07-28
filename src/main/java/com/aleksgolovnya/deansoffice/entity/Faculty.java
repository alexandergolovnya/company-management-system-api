package com.aleksgolovnya.deansoffice.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

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

//    /** Список кафедр данного факультета */
//    @OneToMany(mappedBy = "faculty")
//    private Set<Department> departmentList = new HashSet<>();
}

