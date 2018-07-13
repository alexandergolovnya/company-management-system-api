package com.aleksgolovnya.deansoffice.service.people;

import com.aleksgolovnya.deansoffice.dto.StudentsGroupDto;
import com.aleksgolovnya.deansoffice.entity.Schedule;
import com.aleksgolovnya.deansoffice.entity.StudentsGroup;
import com.aleksgolovnya.deansoffice.service.CommonCrudService;

import java.util.List;

public interface StudentsGroupService extends CommonCrudService<StudentsGroup, StudentsGroupDto> {

    StudentsGroup addStudentsGroup(StudentsGroupDto studentsGroupDto);
    void deleteStudentsGroup(Long id);
    StudentsGroup editStudentsGroup(StudentsGroupDto studentsGroupDto);
    List<StudentsGroup> getAll();
    StudentsGroup getById(Long id);

    @Override
    default StudentsGroupDto covertToDto(StudentsGroup studentsGroup) {
        throw new RuntimeException("Not implemented");
    }
}
