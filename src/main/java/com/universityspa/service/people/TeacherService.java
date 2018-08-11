package com.universityspa.service.people;

import com.universityspa.dto.TeacherDto;
import com.universityspa.entity.Schedule;
import com.universityspa.entity.Teacher;
import com.universityspa.service.CommonCrudService;

import java.util.List;

public interface TeacherService extends CommonCrudService<Teacher, TeacherDto> {
    Teacher addTeacher(TeacherDto teacher);
    void deleteTeacher(Long id);
    Teacher editTeacher(TeacherDto teacher);
    List<Teacher> getAll();
    Teacher getById(Long id);
//    List<Subject> getTeacherSubjects(Long id);
    List<Schedule> getTeachersSchedule(Long id);

    @Override
    default TeacherDto covertToDto(Teacher entity) {
        throw new RuntimeException("Not implemented");
    }
}
