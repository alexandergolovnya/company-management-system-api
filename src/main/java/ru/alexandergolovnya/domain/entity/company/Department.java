package ru.alexandergolovnya.domain.entity.company;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

/**
 * Entity class for Department
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
     * Description of this department
     */
    @Column(length = 4096)
    private String description;

    @CreationTimestamp
    private Date createTime;

    @UpdateTimestamp
    private Date updateTime;

    public Department(String name, String description) {
        this.name = name;
        this.description = description;
    }
}