package com.universityspa.entity.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Entity class for Token for Spring Security
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Token {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Value of token
     */
    @Column
    private String value;

    /**
     * Student to which token belongs
     */
    @ManyToOne
    @JoinColumn(name = "student_id")
    private User user;
}
