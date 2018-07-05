package com.aleksgolovnya.deansoffice.service.schedule;

import com.aleksgolovnya.deansoffice.entity.Schedule;
import com.aleksgolovnya.deansoffice.entity.StudentsGroup;
import com.aleksgolovnya.deansoffice.repository.StudentsGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentsGroupServiceImpl implements StudentsGroupService {

    @Autowired
    private StudentsGroupRepository studentsGroupRepository;

    @Override
    public StudentsGroup addStudentsGroup(StudentsGroup studentsGroup) {
        StudentsGroup savedStudentsGroup = studentsGroupRepository.saveAndFlush(studentsGroup);
        return savedStudentsGroup;
    }

    @Override
    public void deleteStudentsGroup(Long id) {
        StudentsGroup deleteStudentsGroup = studentsGroupRepository.getOne(id);
        studentsGroupRepository.delete(deleteStudentsGroup);

    }

    @Override
    public StudentsGroup editStudentsGroup(StudentsGroup studentsGroup) {
        return studentsGroupRepository.saveAndFlush(studentsGroup);
    }

    @Override
    public List<StudentsGroup> getAll() {
        return studentsGroupRepository.findAll();
    }

    @Override
    public StudentsGroup getById(Long id) {
        StudentsGroup studentsGroup = studentsGroupRepository.getOne(id);
        return studentsGroup;
    }
}
