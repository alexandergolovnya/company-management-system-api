package com.aleksgolovnya.deansoffice.entity;

import lombok.Data;
import javax.persistence.*;

/**
 * Entity class of student group
 */

@Data
@Entity
public class StudentsGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * Name of the student group
     */
    @Column
    private String groupName;

    @Column
    private Long specialtyId;

    /** Специальность для данной группы студентов */
    @ManyToOne
    @JoinColumn(name = "specialtyId", insertable = false, updatable = false)
    private Specialty specialty;
}
