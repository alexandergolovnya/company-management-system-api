package com.aleksgolovnya.deansoffice.service.people;

import com.aleksgolovnya.deansoffice.dto.TeacherDto;
import com.aleksgolovnya.deansoffice.entity.Subject;
import com.aleksgolovnya.deansoffice.entity.Teacher;

import java.util.List;

public interface TeacherService {
    Teacher addTeacher(TeacherDto teacher);
    void deleteTeacher(Long id);
    Teacher editTeacher(TeacherDto teacher);
    List<Teacher> getAll();
    Teacher getById(Long id);
    Teacher convertToEntity(TeacherDto teacherDto);
}
