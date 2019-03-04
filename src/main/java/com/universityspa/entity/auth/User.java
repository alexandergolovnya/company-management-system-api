package com.universityspa.entity.auth;

import com.universityspa.entity.Department;
import com.universityspa.entity.StudentsGroup;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@AllArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue
    private Long id;

    /**
     * E-mail of the user
     */
    @NotNull
    @Column(unique=true)
    private String email;

    /**
     * Password of the user
     */
    @Column
    private String password;

    /**
     * First name of the user
     */
    @Column
    private String firstName;

    /**
     * Middle name of the user
     */
    @Column
    private String middleName;

    /**
     * Last name of the user
     */
    @Column
    private String lastName;

    /**
     * Role of this user
     */
    @Column
    @Enumerated(value = EnumType.STRING)
    private Role role;

    /**
     * State of this user
     */
    @Column
    @Enumerated(value = EnumType.STRING)
    private State state;

    /**
     * List of tokens for this user
     */
    @OneToMany(mappedBy = "user")
    private List<Token> tokens;

    /**
     * Id of a student group to which the
     * user belongs
     */
    @Column
    private Long studentGroupId;

    /**
     * Student group to which the
     * user belongs
     */
    @ManyToOne
    @JoinColumn(name = "studentGroupId", insertable = false, updatable = false)
    private StudentsGroup studentGroup;

    /**
     * Id of the department to which user belongs
     */
    @Column
    private Long departmentId;

    /**
     * Department to which user belongs
     */
    @ManyToOne
    @JoinColumn(name = "departmentId", insertable = false, updatable = false)
    private Department department;

    public User(@NotNull String email, String password, String firstName, String middleName, String lastName, Role role, State state) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.role = role;
        this.state = state;
    }
}
