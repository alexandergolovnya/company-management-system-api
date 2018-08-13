package com.universityspa.dto;

import com.universityspa.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO class for entity @link Student
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentDto {

    private Long id;

    /**
     * First name of the student
     */
    private String firstName;

    /**
     * Last name of the student
     */
    private String lastName;

    /**
     * Number of the course on which
     * student is studying
     */
    private int course;

    /**
     * Student group to which the
     * student belongs
     */
    private Long groupId;

    /**
     * Method converts entity to dto
     * @param entity
     * @return dto
     */
    public static StudentDto convertFromEntityToDTO(Student entity) {
        return StudentDto.builder()
                .id(entity.getId())
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .course(entity.getCourse())
                .groupId(entity.getGroupId())
                .build();
    }
}
