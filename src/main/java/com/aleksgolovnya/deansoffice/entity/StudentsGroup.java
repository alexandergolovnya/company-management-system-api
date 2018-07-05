package com.aleksgolovnya.deansoffice.entity;

import lombok.Data;
import javax.persistence.*;
import java.util.List;

/** Сущность "Группа студентов" */

@Data

@Entity
public class StudentsGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /** Название группы */
    @Column
    private String groupName;

//    /** Расписание данной группы */
//    @OneToMany(mappedBy = "studentsGroup")
//    private List<Schedule> schedule;

//    /** Список студентов группы */
//    @OneToMany(mappedBy = "studentsGroup")
//    private List<Student> studentList;

//    /** Специальность данной группы */
//    @ManyToOne
//    @JoinColumn(name = "specialty_id")
//    private Specialty specialty;

    public StudentsGroup(String groupName) {
        this.groupName = groupName;
    }
}
