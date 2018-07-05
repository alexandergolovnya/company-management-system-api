package com.aleksgolovnya.deansoffice.entity;

import lombok.Data;
import javax.persistence.*;
import java.util.List;

/** Сущность "Преподаватель" */

@Data

@Entity
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /** Имя */
    @Column
    private String firstName;

    /** Фамилия */
    @Column
    private String lastName;

    /** Должность */
    @Column
    private String position;

    /** Кафедра преподавателя */
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

//    /** Расписание для данного преподавателя */
//    @OneToMany(mappedBy = "teacher")
//    private List<Schedule> schedules;

    /** Список предметов для данного преподавателя */
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "teachers_subjects",
            joinColumns = { @JoinColumn(name = "teacher_id") },
            inverseJoinColumns = { @JoinColumn(name = "subject_id") }
    )
    List<Subject> teachers_subjects;

    public Teacher(String firstName, String lastName, String position) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
    }
}
