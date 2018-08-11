package com.universityspa.forms;

import lombok.Data;

/**
 * Class for receiving data from the sign up form
 * in order to create new user
 */

@Data
public class UserForm {

    /**
     * E-mail of the user
     */
    private String email;

    /**
     * Password of the user
     */
    private String password;

    /**
     * Id of the student to which belongs this user
     */
    private Long studentId;

    /**
     * Id of the teacher to which belongs this user
     */
    private Long teacherId;
}
