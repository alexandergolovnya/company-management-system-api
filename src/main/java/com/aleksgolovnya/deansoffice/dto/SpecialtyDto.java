package com.aleksgolovnya.deansoffice.dto;

import lombok.Data;

@Data

public class SpecialtyDto {

    private Long id;
    private String name;
    private String description;
    private Long departmentId;

}
