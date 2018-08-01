package com.aleksgolovnya.deansoffice.service.people;

import com.aleksgolovnya.deansoffice.dto.TeacherDto;
import com.aleksgolovnya.deansoffice.entity.Schedule;
import com.aleksgolovnya.deansoffice.entity.Subject;
import com.aleksgolovnya.deansoffice.entity.Teacher;
import com.aleksgolovnya.deansoffice.service.CommonCrudService;

import java.util.List;

public interface TeacherService extends CommonCrudService<Teacher, TeacherDto> {
    Teacher addTeacher(TeacherDto teacher);
    void deleteTeacher(Long id);
    Teacher editTeacher(TeacherDto teacher);
    List<Teacher> getAll();
    Teacher getById(Long id);
    List<Subject> getTeacherSubjects(Long id);
    List<Schedule> getTeachersSchedule(Long id);

    @Override
    default TeacherDto covertToDto(Teacher entity) {
        throw new RuntimeException("Not implemented");
    }
}
