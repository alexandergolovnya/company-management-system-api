package com.aleksgolovnya.deansoffice.service.people;

import com.aleksgolovnya.deansoffice.entity.Subject;
import com.aleksgolovnya.deansoffice.entity.Teacher;

import java.util.List;

public interface TeacherService {
    Teacher addTeacher(Teacher teacher);
    void deleteTeacher(Long id);
    Teacher editTeacher(Teacher teacher);
    List<Teacher> getAll();
    Teacher getById(Long id);
}
