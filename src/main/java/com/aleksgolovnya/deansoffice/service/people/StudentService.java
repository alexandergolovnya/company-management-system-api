package com.aleksgolovnya.deansoffice.service.people;

import com.aleksgolovnya.deansoffice.dto.StudentDto;
import com.aleksgolovnya.deansoffice.dto.TeacherDto;
import com.aleksgolovnya.deansoffice.entity.Specialty;
import com.aleksgolovnya.deansoffice.entity.Student;
import com.aleksgolovnya.deansoffice.entity.Teacher;

import java.util.List;

public interface StudentService extends CommonCrudService<Student, StudentDto> {
    Student addStudent(StudentDto student);
    void deleteStudent(Long id);
    Student editStudent(StudentDto student);
    List<Student> getAll();
    Student getById(Long id);

    @Override
    default StudentDto covertToDto(Student entity) {
        throw new RuntimeException("Not implemented");
    }
}
