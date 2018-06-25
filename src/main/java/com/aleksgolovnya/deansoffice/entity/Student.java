package com.aleksgolovnya.deansoffice.entity;

import lombok.Data;

import javax.persistence.*;

@Data

@Entity
@Table(name = "students", schema = "public")
public class Student {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "specialization")
    private String specialization;

    @Column(name = "course")
    private String course;

    @Column(name = "average_score")
    private int averageScore;

    @Column(name = "attendance")
    private int attendance;
}
