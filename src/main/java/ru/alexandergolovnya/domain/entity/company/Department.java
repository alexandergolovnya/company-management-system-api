package ru.alexandergolovnya.domain.entity.company;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Entity class for a department of a company
 *
 * @author: Alexander Golovnya <mail@alexandergolovnya.ru>
 * @created: 2019/09/04
 */
@Data
@Entity
public class Department {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id", nullable = false, unique = true, columnDefinition = "int")
    private int id;

    /**
     * Name of this department
     */
    @Column
    private String name;

    /**
     * Photo of this department
     */
    @Column
    private String photo;

    /**
     * Description of this department
     */
    @Column(length = 4096)
    private String description;

    public Department(String name, String description) {
        this.name = name;
        this.description = description;
    }
}