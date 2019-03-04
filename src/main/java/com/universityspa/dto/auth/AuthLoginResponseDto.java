package com.universityspa.dto.auth;

import com.universityspa.entity.auth.Role;
import com.universityspa.entity.auth.Token;
import com.universityspa.entity.auth.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * DTO-class for response to the login request
 */

@Data
@Builder
@AllArgsConstructor
public class AuthLoginResponseDto {

    /**
     * Value of the token
     */
    private String token;

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

    public static AuthLoginResponseDto convertTokenAndUserEntityToDto(Token token, User user) {
        return AuthLoginResponseDto.builder()
                .token(token.getToken())
                .id(user.getId())
                .email(user.getEmail())
                .firstName(user.getFirstName())
                .middleName(user.getMiddleName())
                .lastName(user.getLastName())
                .role(user.getRole())
                .build();
    }
}
