package com.universityspa.dto;

import com.universityspa.entity.Teacher;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO class for entity @link Subject
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TeacherDto {

    private Long id;

    /**
     * First name of the teacher
     */
    private String firstName;

    /**
     * Last name of the teacher
     */
    private String lastName;

    /**
     * Position of the teacher
     */
    private String position;

    /**
     * Department to which teacher belongs
     */
    private Long departmentId;

    /**
     * Method converts entity to dto
     * @param entity
     * @return dto
     */
    public static TeacherDto convertFromEntityToDTO(Teacher entity) {
        return TeacherDto.builder()
                .id(entity.getId())
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .position(entity.getPosition())
                .departmentId(entity.getDepartmentId())
                .build();
    }
}
