package com.aleksgolovnya.deansoffice.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * Entity class for Faculty
 */

@Data
@Entity
public class Faculty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Name of this faculty
     */
    @Column
    private String name;

    /**
     * Description of this faculty
     */
    @Column(length = 4096)
    private String description;
}

