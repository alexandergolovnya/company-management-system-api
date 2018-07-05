package com.aleksgolovnya.deansoffice.service.subjects;

import com.aleksgolovnya.deansoffice.entity.Subject;
import com.aleksgolovnya.deansoffice.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;

    @Override
    public Subject addSubject(Subject subject) {
        Subject savedSubject = subjectRepository.saveAndFlush(subject);
        return savedSubject;
    }

    @Override
    public void deleteSubject(Long id) {
        Subject deleteSubject = subjectRepository.getOne(id);
        subjectRepository.delete(deleteSubject);
        
    }

    @Override
    public Subject editSubject(Subject subject) {
        return subjectRepository.saveAndFlush(subject);
    }

    @Override
    public List<Subject> getAll() {
        return subjectRepository.findAll();
    }

    @Override
    public Subject getById(Long id) {
        Subject subject = subjectRepository.getOne(id);
        return subject;
    }
}
