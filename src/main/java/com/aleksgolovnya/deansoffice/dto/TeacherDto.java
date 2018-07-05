package com.aleksgolovnya.deansoffice.dto;

import lombok.Data;

@Data

public class TeacherDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String position;
    private Long departmentId;
}
