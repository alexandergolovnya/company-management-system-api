package com.aleksgolovnya.deansoffice.service;

import com.aleksgolovnya.deansoffice.entity.Specialty;
import com.aleksgolovnya.deansoffice.entity.Student;

import java.util.List;

public interface StudentService {
    Student addStudent(Student student);
    void deleteStudent(int id);
    Student editStudent(Student student);
    List<Student> getAll();
}
