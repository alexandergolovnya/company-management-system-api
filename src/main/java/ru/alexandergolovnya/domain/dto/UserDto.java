package ru.alexandergolovnya.domain.dto;

import lombok.Builder;
import lombok.Data;
import ru.alexandergolovnya.domain.entity.user.Role;
import ru.alexandergolovnya.domain.entity.user.User;

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

    public static UserDto convertFromEntityToDTO(User user) {
        return UserDto.builder()
                .id(user.getId())
                .email(user.getEmail())
                .firstName(user.getFirstName())
                .middleName(user.getMiddleName())
                .lastName(user.getLastName())
                .role(user.getRole())
//                .departmentId(user.getDepartmentId())
                .build();
    }
}
