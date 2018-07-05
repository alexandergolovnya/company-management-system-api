package com.aleksgolovnya.deansoffice.dto;

import lombok.Data;

import java.util.List;

@Data

public class SubjectDto {
    private Long id;
    private String name;
    private String description;
    private List<Long> teacherId;
}
