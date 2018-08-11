package com.universityspa.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * Entity class for Department
 */

@Data
@Entity
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Name of this department
     */
    @Column
    private String name;

    /**
     * Description of this department
     */
    @Column(length = 4096)
    private String description;

    /**
     * Id af aaculty of this department
     */
    @Column
    private Long facultyId;

    /**
     * Faculty of this department
     */
    @ManyToOne
    @JoinColumn(name = "facultyId", insertable = false, updatable = false)
    private Faculty faculty;
}