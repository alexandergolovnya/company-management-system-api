package com.aleksgolovnya.deansoffice.service;

import com.aleksgolovnya.deansoffice.entity.Subject;

import java.util.List;

public interface SubjectService {
    Subject addSubject(Subject subject);
    void deleteSubject(int id);
    Subject editSubject(Subject subject);
    List<Subject> getAll();
}
