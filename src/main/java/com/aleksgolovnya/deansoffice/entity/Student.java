package com.aleksgolovnya.deansoffice.entity;

import lombok.Data;
import javax.persistence.*;
import java.util.List;

/** Сущность "Студент" */

@Data

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /** Имя */
    @Column
    private String firstName;

    /** Фамилия */
    @Column
    private String lastName;

    /** Курс обучения */
    @Column
    private int course;

    @Column
    private Long groupId;

    /** Группа */
    @ManyToOne
    @JoinColumn(name = "groupId", insertable = false, updatable = false)
    private StudentsGroup studentsGroup;

//    /** Список предметов, которые изучают студенты */
//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(
//            name = "students_subjects",
//            joinColumns = { @JoinColumn(name = "student_id") },
//            inverseJoinColumns = { @JoinColumn(name = "subject_id") }
//    )
//    List<Subject> students_subjects;
}

