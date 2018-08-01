package com.aleksgolovnya.deansoffice.service.studying;

import com.aleksgolovnya.deansoffice.dto.SubjectDto;
import com.aleksgolovnya.deansoffice.entity.Subject;
import com.aleksgolovnya.deansoffice.entity.Teacher;

import java.util.List;

public interface SubjectService {
    Subject addSubject(SubjectDto subject);
    void deleteSubject(Long id);
    Subject editSubject(SubjectDto subject);
    List<Subject> getAll();
    Subject getById(Long id);
    Subject convertToEntity(SubjectDto subjectDto);
//    List<Teacher> getSubjectTeachers(Long id);
}
