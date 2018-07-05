package com.aleksgolovnya.deansoffice.dto;

import com.aleksgolovnya.deansoffice.entity.Journal;
import lombok.Data;

import java.util.Date;

@Data

public class JournalDto {
    private Long id;
    private Long subjectId;
    private Long studentId;
    private Date date;
    private String mark;
}
