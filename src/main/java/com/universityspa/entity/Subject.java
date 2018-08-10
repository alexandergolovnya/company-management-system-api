package com.universityspa.entity;

import lombok.Data;
import javax.persistence.*;
import java.util.List;

/**
 * Entity class for Subject
 */

@Data
@Entity
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    /**
     * Teachers of this subject
     */
//    @ManyToMany
//    @JoinTable(
//            name = "teachers_subjects",
//            joinColumns = { @JoinColumn(name = "subjectId", insertable = false, updatable = false) },
//            inverseJoinColumns = { @JoinColumn(name = "teacherId", insertable = false, updatable = false) }
//    )
//    List<Teacher> teachers;
}

