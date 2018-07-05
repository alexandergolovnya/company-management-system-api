package com.aleksgolovnya.deansoffice.dto;

import lombok.Data;

@Data

public class DepartmentDto {
    private Long id;
    private String name;
    private String description;
    private Long facultyId;
}
