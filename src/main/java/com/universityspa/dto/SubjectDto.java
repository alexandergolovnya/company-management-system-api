package com.universityspa.dto;

import lombok.Data;
import java.util.List;

/**
 * DTO class for entity @link Subject
 */

@Data
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
}
