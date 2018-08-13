package com.universityspa.dto;

import com.universityspa.entity.Specialty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO class for entity @link Specialty
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SpecialtyDto {

    private Long id;

    /**
     * Name of the speciality
     */
    private String name;

    /**
     * Description of the speciality
     */
    private String description;

    /**
     * Department of this speciality
     */
    private Long departmentId;

    /**
     * Method converts entity to dto
     * @param entity
     * @return dto
     */
    public static SpecialtyDto convertFromEntityToDTO(Specialty entity) {
        return SpecialtyDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .description(entity.getDescription())
                .departmentId(entity.getDepartmentId())
                .build();
    }

}
