package com.aleksgolovnya.deansoffice.entity;

import lombok.Data;
import javax.persistence.*;

/**
 * Entity class for student group
 */

@Data
@Entity
public class StudentsGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Name of the student group
     */
    @Column
    private String groupName;

    @Column
    private Long specialtyId;

    /**
     * Specialty for this student group
     */
    @ManyToOne
    @JoinColumn(name = "specialtyId", insertable = false, updatable = false)
    private Specialty specialty;
}
