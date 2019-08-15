package ru.alexandergolovnya.domain.request;

import lombok.Data;

/**
 * Class for receiving data from the sign in form
 * in order to login into users account
 */

@Data
public class LoginRequest {

    /**
     * E-mail of the user
     */
    private String email;

    /**
     * Password of the user
     */
    private String password;
}
