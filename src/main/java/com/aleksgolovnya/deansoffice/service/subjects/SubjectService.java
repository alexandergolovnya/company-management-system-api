package com.aleksgolovnya.deansoffice.service.subjects;

import com.aleksgolovnya.deansoffice.dto.StudentDto;
import com.aleksgolovnya.deansoffice.dto.SubjectDto;
import com.aleksgolovnya.deansoffice.entity.Subject;

import java.util.List;

public interface SubjectService {
    Subject addSubject(SubjectDto subject);
    void deleteSubject(Long id);
    Subject editSubject(SubjectDto subject);
    List<Subject> getAll();
    Subject getById(Long id);
    Subject convertToEntity(SubjectDto subjectDto);
}
