package com.universityspa.service.people;

import com.universityspa.dto.StudentsGroupDto;
import com.universityspa.entity.StudentsGroup;
import com.universityspa.exception.NotFoundException;
import com.universityspa.service.abstracts.CommonCrudService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;

public interface StudentsGroupService extends CommonCrudService<StudentsGroup, StudentsGroupDto> {

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    StudentsGroupDto addStudentsGroup(StudentsGroupDto studentsGroupDto);

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    void deleteStudentsGroup(Long id) throws NotFoundException;

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    StudentsGroupDto editStudentsGroup(Long id, StudentsGroupDto studentsGroupDto) throws NotFoundException;

    @PreAuthorize("hasAnyAuthority('TEACHER', 'STUDENT', 'ADMIN')")
    Page<StudentsGroupDto> getAll(Pageable pageable);

    @PreAuthorize("hasAnyAuthority('TEACHER', 'STUDENT', 'ADMIN')")
    StudentsGroupDto getById(Long id) throws NotFoundException;

    @PreAuthorize("hasAnyAuthority('TEACHER', 'STUDENT', 'ADMIN')")
    Page<StudentsGroupDto> getSpecialtyStudentGroups(Long id, Pageable pageable);
}
