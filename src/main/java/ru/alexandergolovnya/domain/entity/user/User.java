package ru.alexandergolovnya.domain.entity.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;
import ru.alexandergolovnya.domain.entity.company.Department;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

/**
 * @author: Alexander Golovnya <mail@alexandergolovnya.ru>
 * @created: 2019/09/04
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id", nullable = false, unique = true, columnDefinition = "int")
    private int id;

    @NotNull
    @Column(unique=true)
    private String email;

    @Column
    @NotEmpty
    @Size(min=3, message = "Length must be more than 3")
    private String password;

    @Column
    @NotEmpty
    @Size(min=2, message = "Length must be more than 2")
    private String firstName;

    @Column
    @NotEmpty
    @Size(min=2, message = "Length must be more than 2")
    private String middleName;

    @Column
    @NotEmpty
    @Size(min=2, message = "Length must be more than 2")
    private String lastName;

    @Column(length = 1096)
    private String photo;

    @Column(length = 4096)
    private String description;

    @Column(name = "department_id", insertable = false, updatable = false)
    private Integer departmentId;

    @Column
    @Enumerated(value = EnumType.STRING)
    private Role role;

    @Column
    @Enumerated(value = EnumType.STRING)
    private State state;

    /**
     * List of tokens for this user
     */
    @OneToMany(mappedBy = "user")
    private List<Token> tokens;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @CreationTimestamp
    private Date createTime;

    @UpdateTimestamp
    private Date updateTime;
}
