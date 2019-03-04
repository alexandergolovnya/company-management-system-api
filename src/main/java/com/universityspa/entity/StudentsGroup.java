package com.universityspa.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * Entity class for student group
 */

@Data
@Entity
public class StudentsGroup {

    @Id
    @GeneratedValue
    private Long id;

    /**
     * Name of the student group
     */
    @Column
    private String groupName;

    /**
     * Id of a specialty to which a
     * student group belongs
     */
    @Column
    private Long specialtyId;

    /**
     * Specialty for this student group
     */
    @ManyToOne
    @JoinColumn(name = "specialtyId", insertable = false, updatable = false)
    private Specialty specialty;

    public StudentsGroup(String groupName, Long specialtyId) {
        this.groupName = groupName;
        this.specialtyId = specialtyId;
    }
}
