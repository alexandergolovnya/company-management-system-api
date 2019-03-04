package com.universityspa.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Entity class for Subject
 */

@Data
@Entity
public class Subject {

    @Id
    @GeneratedValue
    private Long id;

    /**
     * Name of the subject
     */
    @Column
    private String name;

    /**
     * Description of the subject
     */
    @Column(length = 4096)
    private String description;
}

