package com.aleksgolovnya.deansoffice.service.people;

import com.aleksgolovnya.deansoffice.dto.StudentDto;
import com.aleksgolovnya.deansoffice.entity.Student;
import com.aleksgolovnya.deansoffice.service.CommonCrudService;
import java.util.List;

public interface StudentService extends CommonCrudService<Student, StudentDto> {

    Student addStudent(StudentDto studentDto);
    void deleteStudent(Long id);
    Student editStudent(StudentDto studentDto);
    List<Student> getAll();
    Student getById(Long id);

    @Override
    default StudentDto covertToDto(Student student) {
        throw new RuntimeException("Not implemented");
    }
}
