package com.universityspa.dto.forms;

import lombok.Data;

/**
 * Class for receiving data from the sign in form
 * in order to login into users account
 */

@Data
public class LoginForm {

    /**
     * E-mail of the user
     */
    private String email;

    /**
     * Password of the user
     */
    private String password;
}
