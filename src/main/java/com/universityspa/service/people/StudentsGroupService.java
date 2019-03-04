package com.universityspa.service.people;

import com.universityspa.dto.StudentsGroupDto;
import com.universityspa.entity.StudentsGroup;
import com.universityspa.exception.NotFoundException;
import com.universityspa.service.abstracts.CommonCrudService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;

public interface StudentsGroupService extends CommonCrudService<StudentsGroup, StudentsGroupDto> {

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    StudentsGroupDto addStudentsGroup(StudentsGroupDto studentsGroupDto);

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    void deleteStudentsGroup(Long id) throws NotFoundException;

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    StudentsGroupDto editStudentsGroup(Long id, StudentsGroupDto studentsGroupDto) throws NotFoundException;

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_USER')")
    Page<StudentsGroupDto> getAll(Pageable pageable);

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_USER')")
    StudentsGroupDto getById(Long id) throws NotFoundException;

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_USER')")
    Page<StudentsGroupDto> getSpecialtyStudentGroups(Long id, Pageable pageable);
}
