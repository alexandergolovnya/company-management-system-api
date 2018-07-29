package com.aleksgolovnya.deansoffice.entity;

import lombok.Data;
import javax.persistence.*;
import java.util.List;

/** Сущность "Специальность" */

@Data

@Entity
public class Specialty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Название специальности */
    @Column
    private String name;

    /** Описание Специализации */
    @Column(length = 4096)
    private String description;

    @Column
    private Long departmentId;

    /** Кафедра для данной специализации */
    @ManyToOne
    @JoinColumn(name = "departmentId", insertable = false, updatable = false)
    private Department department;

//    /** Грыппы студентов, обучающиеся на данной специальности */
//    @OneToMany(mappedBy = "specialty")
//    private List<StudentsGroup> studentsGroups;
}
