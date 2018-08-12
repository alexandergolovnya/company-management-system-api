package com.universityspa.service.studying;

import com.universityspa.dto.SubjectDto;
import com.universityspa.entity.Subject;
import com.universityspa.exception.NotFoundException;
import com.universityspa.service.CommonCrudService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SubjectService extends CommonCrudService<Subject, SubjectDto> {

    SubjectDto addSubject(SubjectDto subjectDto);
    void deleteSubject(Long id) throws NotFoundException;
    SubjectDto editSubject(Long id, SubjectDto subjectDto) throws NotFoundException;
    Page<SubjectDto> getAll(Pageable pageable);
    SubjectDto getById(Long id) throws NotFoundException;
}
