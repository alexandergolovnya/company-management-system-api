package com.universityspa.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * Entity class for Specialty
 */

@Data
@Entity
public class Specialty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Name of the speciality
     */
    @Column
    private String name;

    /**
     * Description of the speciality
     */
    @Column(length = 4096)
    private String description;

    /**
     * Id of a department of this speciality
     */
    @Column
    private Long departmentId;

    /**
     * Department of this speciality
     */
    @ManyToOne
    @JoinColumn(name = "departmentId", insertable = false, updatable = false)
    private Department department;
}
