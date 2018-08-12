package com.universityspa.service.people;

import com.universityspa.dto.StudentDto;
import com.universityspa.entity.Student;
import com.universityspa.exception.NotFoundException;
import com.universityspa.service.CommonCrudService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface StudentService extends CommonCrudService<Student, StudentDto> {

    StudentDto addStudent(StudentDto studentDto);
    void deleteStudent(Long id) throws NotFoundException;
    StudentDto editStudent(Long id, StudentDto studentDto) throws NotFoundException;
    Page<StudentDto> getAll(Pageable pageable);
    StudentDto getById(Long id) throws NotFoundException;
}
