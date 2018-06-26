package com.aleksgolovnya.deansoffice.entity;

import lombok.Data;
import javax.persistence.*;
import java.util.List;

/** Сущность "Преподаватель" */

@Data

@Entity
@Table(name = "teachers", schema = "public")
public class Teacher {

    @Id
    @GeneratedValue
    private int id;

    /* Имя */
    @Column(name = "first_name")
    private String firstName;

    /* Фамилия */
    @Column(name = "last_name")
    private String lastName;

    /* Кафедра */
    @Column(name = "department")
    private String department;

    /* Должность */
    @Column(name = "position")
    private String position;

    /* Нагрузка */
    @Column(name = "work_load")
    private String workLoad;

    /* Расписание */
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "schedule_id")
    private Schedule teacher_schedule;
    /* Список предметов для данного преподавателя */
    @OneToMany(mappedBy = "teacher")
    private List<Subject> subjectList;
}
