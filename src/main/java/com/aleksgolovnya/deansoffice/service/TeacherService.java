package com.aleksgolovnya.deansoffice.service;

import com.aleksgolovnya.deansoffice.entity.Subject;
import com.aleksgolovnya.deansoffice.entity.Teacher;

import java.util.List;

public interface TeacherService {
    Teacher addTeacher(Teacher teacher);
    void deleteTeacher(int id);
    Teacher editTeacher(Teacher teacher);
    List<Teacher> getAll();
}
