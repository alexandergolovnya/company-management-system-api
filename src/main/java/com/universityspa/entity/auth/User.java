package com.universityspa.entity.auth;

import com.universityspa.entity.Student;
import com.universityspa.entity.Teacher;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
     * Id of the student to which belongs this user
     */
    private Long studentId;

    /**
     * Id of the teacher to which belongs this user
     */
    private Long teacherId;

    /**
     * Matching this user with student
     */
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "studentId", insertable = false, updatable = false)
    private Student student;

    /**
     * Matching this user with teacher
     */
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teacherId", insertable = false, updatable = false)
    private Teacher teacher;

    /**
     * List of tokens for this user
     */
    @OneToMany(mappedBy = "user")
    private List<Token> tokens;
}
