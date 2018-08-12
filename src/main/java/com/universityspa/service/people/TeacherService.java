package com.universityspa.service.people;

import com.universityspa.dto.TeacherDto;
import com.universityspa.entity.Schedule;
import com.universityspa.entity.Teacher;
import com.universityspa.service.CommonCrudService;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

public interface TeacherService extends CommonCrudService<Teacher, TeacherDto> {

    @PreAuthorize("hasAuthority('ADMIN')")
    Teacher addTeacher(TeacherDto teacher);

    @PreAuthorize("hasAuthority('ADMIN')")
    void deleteTeacher(Long id);

    @PreAuthorize("hasAnyAuthority('TEACHER', 'ADMIN')")
    Teacher editTeacher(TeacherDto teacher);

    @PreAuthorize("hasAnyAuthority('TEACHER', 'STUDENT', 'ADMIN')")
    List<Teacher> getAll();

    @PreAuthorize("hasAnyAuthority('TEACHER', 'STUDENT', 'ADMIN')")
    Teacher getById(Long id);

    @PreAuthorize("hasAnyAuthority('TEACHER', 'ADMIN')")
    List<Schedule> getTeachersSchedule(Long id);

    @Override
    default TeacherDto convertToDto(Teacher entity) {
        throw new RuntimeException("Not implemented");
    }
}
