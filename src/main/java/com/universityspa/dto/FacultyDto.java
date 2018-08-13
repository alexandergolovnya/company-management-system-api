package com.universityspa.dto;

import com.universityspa.entity.Faculty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO class for entity @link Facult
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FacultyDto {

    private Long id;

    /**
     * Name of this faculty
     */
    private String name;

    /**
     * Description of this faculty
     */
    private String description;

    /**
     * Method converts entity to dto
     * @param entity
     * @return dto
     */
    public static FacultyDto convertFromEntityToDTO(Faculty entity) {
        return FacultyDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .description(entity.getDescription())
                .build();
    }
}
