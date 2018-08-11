package com.universityspa.service.studying;

import com.universityspa.dto.SubjectDto;
import com.universityspa.entity.Subject;

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
