package com.universityspa.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Entity class for Student
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
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
}

