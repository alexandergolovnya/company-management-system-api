package com.universityspa.dto.auth;

import com.universityspa.entity.auth.Role;
import com.universityspa.entity.auth.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

/**
 * DTO-class for entity User
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {

    /**
     * Id of the user
     */
    private Long id;

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
     * Id of the student to which belongs this user
     */
    private Long studentGroupID;

    /**
     * Id of the teacher to which belongs this user
     */
    private Long departmentId;

    public static UserDto convertFromEntityToDTO(User user) {
        return UserDto.builder()
                .id(user.getId())
                .email(user.getEmail())
                .firstName(user.getFirstName())
                .middleName(user.getMiddleName())
                .lastName(user.getLastName())
                .role(user.getRole())
                .studentGroupID(user.getStudentGroupId())
                .departmentId(user.getDepartmentId())
                .build();
    }

    public static List<UserDto> convertFromEntityToDTO(List<User> users) {
        return users.stream().map(UserDto::convertFromEntityToDTO).collect(Collectors.toList());
    }
}
