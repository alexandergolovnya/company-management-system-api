package com.aleksgolovnya.deansoffice.service.people;

import com.aleksgolovnya.deansoffice.entity.Teacher;
import com.aleksgolovnya.deansoffice.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements  TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    @Override
    public Teacher addTeacher(Teacher teacher) {
        Teacher savedTeacher = teacherRepository.saveAndFlush(teacher);
        return savedTeacher;
    }

    @Override
    public void deleteTeacher(Long id) {
        Teacher deleteTeacher = teacherRepository.getOne(id);
        teacherRepository.delete(deleteTeacher);
    }

    @Override
    public Teacher editTeacher(Teacher teacher) {
        return teacherRepository.saveAndFlush(teacher);
    }

    @Override
    public List<Teacher> getAll() {
        return teacherRepository.findAll();
    }

    @Override
    public Teacher getById(Long id) {
        Teacher teacher = teacherRepository.getOne(id);
        return teacher;
    }
}
