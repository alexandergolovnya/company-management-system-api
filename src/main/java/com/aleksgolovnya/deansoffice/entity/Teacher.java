package com.aleksgolovnya.deansoffice.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * Entity class for Teacher
 */

@Data
@Entity
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * First name of the teacher
     */
    @Column
    private String firstName;

    /**
     * Last name of the teacher
     */
    @Column
    private String lastName;

    /**
     * Position of the teacher
     */
    @Column
    private String position;

    /**
     * Id of the department to which teacher belongs
     */
    @Column
    private Long departmentId;

    /**
     * Department to which teacher belongs
     */
    @ManyToOne
    @JoinColumn(name = "departmentId", insertable = false, updatable = false)
    private Department department;

//    /** Список предметов для данного преподавателя */
//    @ManyToMany(mappedBy = "teachers")
//    private List<Subject> subjects;
}
