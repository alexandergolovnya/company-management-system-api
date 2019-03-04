package com.universityspa.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Entity class for Faculty
 */

@Data
@Entity
public class Faculty {

    @Id
    @GeneratedValue
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

    public Faculty(String name, String description) {
        this.name = name;
        this.description = description;
    }
}

