package com.aleksgolovnya.deansoffice.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/** Оценка */

@Data

@Entity
public class Score {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /** Значение оценки */
    @Column
    String scoreValue;

    public Score(String scoreValue) {
        this.scoreValue = scoreValue;
    }
}
