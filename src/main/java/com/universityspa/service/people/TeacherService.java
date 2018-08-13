package com.universityspa.service.people;

import com.universityspa.dto.TeacherDto;
import com.universityspa.entity.Teacher;
import com.universityspa.exception.NotFoundException;
import com.universityspa.service.abstracts.CommonCrudService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;

public interface TeacherService extends CommonCrudService<Teacher, TeacherDto> {

    @PreAuthorize("hasAuthority('ADMIN')")
    TeacherDto addTeacher(TeacherDto teacherDto);

    @PreAuthorize("hasAuthority('ADMIN')")
    void deleteTeacher(Long id) throws NotFoundException;

    @PreAuthorize("hasAnyAuthority('TEACHER', 'ADMIN')")
    TeacherDto editTeacher(Long id, TeacherDto teacherDto) throws NotFoundException;

    @PreAuthorize("hasAnyAuthority('TEACHER', 'STUDENT', 'ADMIN')")
    Page<TeacherDto> getAll(Pageable pageable);

    @PreAuthorize("hasAnyAuthority('TEACHER', 'STUDENT', 'ADMIN')")
    TeacherDto getById(Long id) throws NotFoundException;

    @PreAuthorize("hasAnyAuthority('TEACHER', 'STUDENT', 'ADMIN')")
    Page<TeacherDto> getDepartmentTeachers(Long id, Pageable pageable);
}
