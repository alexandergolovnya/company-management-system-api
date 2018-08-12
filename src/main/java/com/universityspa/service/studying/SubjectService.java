package com.universityspa.service.studying;

import com.universityspa.dto.SubjectDto;
import com.universityspa.entity.Subject;
import com.universityspa.exception.NotFoundException;
import com.universityspa.service.abstracts.CommonCrudService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;

public interface SubjectService extends CommonCrudService<Subject, SubjectDto> {

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    SubjectDto addSubject(SubjectDto subjectDto);

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    void deleteSubject(Long id) throws NotFoundException;

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    SubjectDto editSubject(Long id, SubjectDto subjectDto) throws NotFoundException;

    @PreAuthorize("hasAnyAuthority('TEACHER', 'STUDENT', 'ADMIN')")
    Page<SubjectDto> getAll(Pageable pageable);

    @PreAuthorize("hasAnyAuthority('TEACHER', 'STUDENT', 'ADMIN')")
    SubjectDto getById(Long id) throws NotFoundException;
}
