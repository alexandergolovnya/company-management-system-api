package com.aleksgolovnya.deansoffice.dto;

import lombok.Data;

@Data

public class StudentDto {

    private Long id;
    private String firstName;
    private String lastName;
    private int course;
    private Long groupId;
}
