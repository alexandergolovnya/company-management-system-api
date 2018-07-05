package com.aleksgolovnya.deansoffice.service.schedule;

import com.aleksgolovnya.deansoffice.entity.Schedule;
import com.aleksgolovnya.deansoffice.entity.StudentsGroup;

import java.util.List;

public interface StudentsGroupService {
    StudentsGroup addStudentsGroup(StudentsGroup studentsGroup);
    void deleteStudentsGroup(Long id);
    StudentsGroup editStudentsGroup(StudentsGroup studentsGroup);
    List<StudentsGroup> getAll();
    StudentsGroup getById(Long id);
}
