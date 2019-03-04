package com.universityspa.service.university;

import com.universityspa.dto.FacultyDto;
import com.universityspa.entity.Faculty;
import com.universityspa.exception.NotFoundException;
import com.universityspa.service.abstracts.CommonCrudService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;

public interface FacultyService extends CommonCrudService<Faculty, FacultyDto> {

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    FacultyDto addFaculty(FacultyDto facultyDto);

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    void deleteFaculty(Long id) throws NotFoundException;

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    FacultyDto editFaculty(Long id, FacultyDto facultyDto) throws NotFoundException;

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_USER')")
    Page<FacultyDto> getAll(Pageable pageable);

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_USER')")
    FacultyDto getById(Long id) throws NotFoundException;
}
