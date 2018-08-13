package com.universityspa.dto;

import com.universityspa.entity.Department;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO class for entity @link Department
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DepartmentDto {

    private Long id;

    /**
     * Name of this department
     */
    private String name;

    /**
     * Description of this department
     */
    private String description;

    /**
     * Faculty of this department
     */
    private Long facultyId;

    /**
     * Method converts entity to dto
     * @param entity
     * @return dto
     */
    public static DepartmentDto convertFromEntityToDTO(Department entity) {
        return DepartmentDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .description(entity.getDescription())
                .facultyId(entity.getFacultyId())
                .build();
    }
}
