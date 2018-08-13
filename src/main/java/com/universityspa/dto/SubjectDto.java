package com.universityspa.dto;

import com.universityspa.entity.Subject;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * DTO class for entity @link Subject
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SubjectDto {

    private Long id;

    /**
     * Name of the subject
     */
    private String name;

    /**
     * Description of the subject
     */
    private String description;

    /**
     * Method converts entity to dto
     * @param entity
     * @return dto
     */
    public static SubjectDto convertFromEntityToDTO(Subject entity) {
        return SubjectDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .description(entity.getDescription())
                .build();
    }
}
