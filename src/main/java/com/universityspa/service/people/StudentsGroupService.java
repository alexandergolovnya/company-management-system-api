package com.universityspa.service.people;

import com.universityspa.dto.StudentsGroupDto;
import com.universityspa.entity.StudentsGroup;
import com.universityspa.exception.NotFoundException;
import com.universityspa.service.abstracts.CommonCrudService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface StudentsGroupService extends CommonCrudService<StudentsGroup, StudentsGroupDto> {

    StudentsGroupDto addStudentsGroup(StudentsGroupDto studentsGroupDto);
    void deleteStudentsGroup(Long id) throws NotFoundException;
    StudentsGroupDto editStudentsGroup(Long id, StudentsGroupDto studentsGroupDto) throws NotFoundException;
    Page<StudentsGroupDto> getAll(Pageable pageable);
    StudentsGroupDto getById(Long id) throws NotFoundException;
    Page<StudentsGroupDto> getSpecialtyStudentGroups(Long id, Pageable pageable);
}
