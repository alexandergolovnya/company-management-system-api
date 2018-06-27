package com.aleksgolovnya.deansoffice.service;

import com.aleksgolovnya.deansoffice.entity.Subject;
import com.aleksgolovnya.deansoffice.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;

    @Override
    public Subject addSubject(Subject subject) {
        Subject savedSubject = subjectRepository.saveAndFlush(subject);
        return savedSubject;
    }

    @Override
    public void deleteSubject(int id) {

    }

    @Override
    public Subject editSubject(Subject subject) {
        return subjectRepository.saveAndFlush(subject);
    }

    @Override
    public List<Subject> getAll() {
        return subjectRepository.findAll();
    }
}
