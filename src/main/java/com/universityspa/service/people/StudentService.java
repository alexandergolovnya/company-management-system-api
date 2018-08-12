package com.universityspa.service.people;

import com.universityspa.dto.StudentDto;
import com.universityspa.entity.Student;
import com.universityspa.exception.NotFoundException;
import com.universityspa.service.abstracts.CommonCrudService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;

public interface StudentService extends CommonCrudService<Student, StudentDto> {

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    StudentDto addStudent(StudentDto studentDto);

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    void deleteStudent(Long id) throws NotFoundException;

    @PreAuthorize("hasAnyAuthority('STUDENT', 'ADMIN')")
    StudentDto editStudent(Long id, StudentDto studentDto) throws NotFoundException;

    @PreAuthorize("hasAnyAuthority('TEACHER', 'STUDENT', 'ADMIN')")
    Page<StudentDto> getAll(Pageable pageable);

    @PreAuthorize("hasAnyAuthority('TEACHER', 'STUDENT', 'ADMIN')")
    StudentDto getById(Long id) throws NotFoundException;
}
