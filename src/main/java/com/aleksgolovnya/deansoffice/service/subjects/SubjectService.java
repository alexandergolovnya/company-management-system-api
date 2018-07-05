package com.aleksgolovnya.deansoffice.service.subjects;

import com.aleksgolovnya.deansoffice.entity.Subject;

import java.util.List;

public interface SubjectService {
    Subject addSubject(Subject subject);
    void deleteSubject(Long id);
    Subject editSubject(Subject subject);
    List<Subject> getAll();
    Subject getById(Long id);
}
