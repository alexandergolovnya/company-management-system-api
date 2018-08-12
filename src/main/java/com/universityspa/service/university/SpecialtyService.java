package com.universityspa.service.university;

import com.universityspa.dto.SpecialtyDto;
import com.universityspa.entity.Specialty;
import com.universityspa.exception.NotFoundException;
import com.universityspa.service.abstracts.CommonCrudService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;

public interface SpecialtyService extends CommonCrudService<Specialty, SpecialtyDto> {

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    SpecialtyDto addSpecialty(SpecialtyDto specialty);

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    void deleteSpecialty(Long id) throws NotFoundException;

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    SpecialtyDto editSpecialty(Long id, SpecialtyDto specialty) throws NotFoundException;

    @PreAuthorize("hasAnyAuthority('TEACHER', 'STUDENT', 'ADMIN')")
    Page<SpecialtyDto> getAll(Pageable pageable);

    @PreAuthorize("hasAnyAuthority('TEACHER', 'STUDENT', 'ADMIN')")
    SpecialtyDto getById(Long id) throws NotFoundException;

    @PreAuthorize("hasAnyAuthority('TEACHER', 'STUDENT', 'ADMIN')")
    Page<SpecialtyDto> getDepartmentSpecialties(Long id, Pageable pageable);
}
