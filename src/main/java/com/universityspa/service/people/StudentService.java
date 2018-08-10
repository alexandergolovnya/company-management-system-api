package com.universityspa.service.people;

import com.universityspa.dto.StudentDto;
import com.universityspa.entity.Student;
import com.universityspa.service.CommonCrudService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface StudentService extends CommonCrudService<Student, StudentDto> {

    Student addStudent(StudentDto studentDto);
    void deleteStudent(Long id);
    Student editStudent(StudentDto studentDto);
    Page<Student> getAll(Pageable pageable);
    Student getById(Long id);

    @Override
    default StudentDto covertToDto(Student student) {
        throw new RuntimeException("Not implemented");
    }
}
