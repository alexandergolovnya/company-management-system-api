package com.aleksgolovnya.deansoffice.dto.auth;

import com.aleksgolovnya.deansoffice.entity.auth.User;
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
     * Id of the student to which belongs this user
     */
    private Long studentId;

    /**
     * Id of the teacher to which belongs this user
     */
    private Long teacherId;

    public static UserDto from(User user) {
        return UserDto.builder()
                .id(user.getId())
                .email(user.getEmail())
                .studentId(user.getStudentId())
                .teacherId(user.getTeacherId())
                .build();
    }

    public static List<UserDto> from(List<User> users) {
        return users.stream().map(UserDto::from).collect(Collectors.toList());
    }
}
