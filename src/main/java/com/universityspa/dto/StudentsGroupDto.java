package com.universityspa.dto;

import com.universityspa.entity.StudentsGroup;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO class for entity @link StudentsGroup
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentsGroupDto {

    private Long id;

    /**
     * Name of the student group
     */
    private String groupName;

    /**
     * Specialty for this student group
     */
    private Long specialtyId;

    /**
     * Method converts entity to dto
     * @param entity
     * @return dto
     */
    public static StudentsGroupDto convertFromEntityToDTO(StudentsGroup entity) {
        return StudentsGroupDto.builder()
                .id(entity.getId())
                .groupName(entity.getGroupName())
                .specialtyId(entity.getSpecialtyId())
                .build();
    }
}
