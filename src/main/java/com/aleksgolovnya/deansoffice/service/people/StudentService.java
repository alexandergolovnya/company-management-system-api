package com.aleksgolovnya.deansoffice.service.people;

import com.aleksgolovnya.deansoffice.dto.StudentDto;
import com.aleksgolovnya.deansoffice.entity.Specialty;
import com.aleksgolovnya.deansoffice.entity.Student;

import java.util.List;

public interface StudentService {
    Student addStudent(StudentDto student);
    void deleteStudent(Long id);
    Student editStudent(StudentDto student);
    List<Student> getAll();
    Student getById(Long id);
    Student convertToEntity(StudentDto studentDto);
}
