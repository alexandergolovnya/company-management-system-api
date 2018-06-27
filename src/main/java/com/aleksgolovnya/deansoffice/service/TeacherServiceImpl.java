package com.aleksgolovnya.deansoffice.service;

import com.aleksgolovnya.deansoffice.entity.Teacher;
import com.aleksgolovnya.deansoffice.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TeacherServiceImpl implements  TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    @Override
    public Teacher addTeacher(Teacher teacher) {
        Teacher savedTeacher = teacherRepository.saveAndFlush(teacher);
        return savedTeacher;
    }

    @Override
    public void deleteTeacher(int id) {

    }

    @Override
    public Teacher editTeacher(Teacher teacher) {
        return teacherRepository.saveAndFlush(teacher);
    }

    @Override
    public List<Teacher> getAll() {
        return teacherRepository.findAll();
    }
}
