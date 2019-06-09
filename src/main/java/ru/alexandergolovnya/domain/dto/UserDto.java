package ru.alexandergolovnya.domain.dto;

import ru.alexandergolovnya.domain.entity.user.Role;
import lombok.Builder;
import lombok.Data;

/**
 * DTO-class for entity User
 */

@Data
@Builder
public class UserDto {

    /**
     * Id of the user
     */
    private int id;

    /**
     * Access token of the user
     */
    private String token;

    /**
     * E-mail of the user
     */
    private String email;

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

    /**
     * Role of the user
     */
    private Role role;

    /**
     * Id of the teacher to which belongs this user
     */
    private int departmentId;
}
