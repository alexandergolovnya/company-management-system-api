package com.aleksgolovnya.deansoffice.entity;

import lombok.Data;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

/** Сущность "Журнал" */

@Data

@Entity
public class Journal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private Long subjectId;
    @Column
    private Long studentId;
    @Column
    private Long scoreId;
    @Column
    private Date date;

    /** Предметы */
    @ManyToOne
    @JoinColumn(name = "subjectId", insertable = false, updatable = false)
    private Subject subject;

    /** Студент */
    @ManyToOne
    @JoinColumn(name = "studentId", insertable = false, updatable = false)
    private Student student;

    /** Отметки */
    @ManyToOne
    @JoinColumn(name = "scoreId", insertable = false, updatable = false)
    private Score score;
}
