package com.universityspa.dto.forms;

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
     * First name of the user
     */
    private String firstName;

    /**
     * Middle name of the user
     */
    private String middleName;

    /**
     * Last name of the user
     */
    private String lastName;
}
