package com.aleksgolovnya.deansoffice.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/** Сущность "Факультет" */

@Data

@Entity
public class Faculty {

    @Id
    @GeneratedValue
    private int faculty_id;

    /* Название факультета */
    @Column(name = "name")
    private String name;

    /* Описание факультета */
    @Column(name = "description")
    private String description;

    /* Список кафедр данного факультета */
    @OneToMany(mappedBy = "faculty")
    private List<Department> departmentList;
}
