package com.universityspa.entity;

import lombok.Data;

import javax.persistence.*;

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
}
