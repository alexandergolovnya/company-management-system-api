package com.aleksgolovnya.deansoffice.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * Entity class for Student
 */

@Data

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * First name of the student
     */
    @Column
    private String firstName;

    /**
     * Last name of the student
     */
    @Column
    private String lastName;

    /**
     * Number of the course on which
     * student is studying
     */
    @Column
    private int course;

    /**
     * Id of a student group to which the
     * student belongs
     */
    @Column
    private Long groupId;

    /**
     * Student group to which the
     * student belongs
     */
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

