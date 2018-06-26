package com.aleksgolovnya.deansoffice.service;

import com.aleksgolovnya.deansoffice.entity.Specialty;
import com.aleksgolovnya.deansoffice.entity.Student;
import com.aleksgolovnya.deansoffice.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student addStudent(Student student) {
        Student savedStudent = studentRepository.saveAndFlush(student);
        return savedStudent;
    }

    @Override
    public void deleteStudent(int id) {

    }

    @Override
    public Student editStudent(Student student) {
        return studentRepository.saveAndFlush(student);
    }

    @Override
    public List<Student> getAll() {
        return studentRepository.findAll();
    }
}
