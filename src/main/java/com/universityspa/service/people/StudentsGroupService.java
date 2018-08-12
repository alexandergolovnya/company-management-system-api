package com.universityspa.service.people;

import com.universityspa.dto.StudentsGroupDto;
import com.universityspa.entity.Student;
import com.universityspa.entity.StudentsGroup;
import com.universityspa.service.abstracts.CommonCrudService;

import java.util.List;

public interface StudentsGroupService extends CommonCrudService<StudentsGroup, StudentsGroupDto> {

    StudentsGroup addStudentsGroup(StudentsGroupDto studentsGroupDto);
    void deleteStudentsGroup(Long id);
    StudentsGroup editStudentsGroup(StudentsGroupDto studentsGroupDto);
    List<StudentsGroup> getAll();
    StudentsGroup getById(Long id);
    List<Student> getStudentGroupStudents(Long id);

    @Override
    default StudentsGroupDto convertToDto(StudentsGroup studentsGroup) {
        throw new RuntimeException("Not implemented");
    }
}
