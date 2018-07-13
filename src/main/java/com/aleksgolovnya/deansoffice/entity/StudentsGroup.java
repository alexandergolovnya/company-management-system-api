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
}
