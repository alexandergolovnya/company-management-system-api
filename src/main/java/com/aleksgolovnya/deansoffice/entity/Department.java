package com.aleksgolovnya.deansoffice.entity;

import lombok.Data;
import javax.persistence.*;
import java.util.List;

/** Сущность "Кафедра" */

@Data

@Entity
@Table(name = "departments", schema = "public")
public class Department {

    @Id
    @GeneratedValue
    private int department_id;

    /* Название кафедры */
    @Column(name = "name")
    private String name;

    /* Описание кафедры */
    @Column(name = "description")
    private String description;

    /* Факультет к которому относится кафедра */
    @ManyToOne
    @JoinColumn(name = "faculty_id")
    private Faculty faculty;

    /* Список специализаций данной кафедры */
    @OneToMany(mappedBy = "department")
    private List<Specialty> specialtyList;

    /* Список специализаций данной кафедры */
    @OneToMany(mappedBy = "department")
    private List<Teacher> teacherList;
}
