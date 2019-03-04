package com.universityspa.service.studying;

import com.universityspa.dto.SubjectDto;
import com.universityspa.entity.Subject;
import com.universityspa.exception.NotFoundException;
import com.universityspa.service.abstracts.CommonCrudService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;

public interface SubjectService extends CommonCrudService<Subject, SubjectDto> {

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    SubjectDto addSubject(SubjectDto subjectDto);

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    void deleteSubject(Long id) throws NotFoundException;

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    SubjectDto editSubject(Long id, SubjectDto subjectDto) throws NotFoundException;

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_USER')")
    Page<SubjectDto> getAll(Pageable pageable);

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_USER')")
    SubjectDto getById(Long id) throws NotFoundException;
}
