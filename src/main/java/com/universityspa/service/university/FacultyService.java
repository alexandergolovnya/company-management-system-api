package com.universityspa.service.university;

import com.universityspa.dto.FacultyDto;
import com.universityspa.entity.Faculty;
import com.universityspa.exception.NotFoundException;
import com.universityspa.service.abstracts.CommonCrudService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FacultyService extends CommonCrudService<Faculty, FacultyDto> {

    FacultyDto addFaculty(FacultyDto facultyDto);
    void deleteFaculty(Long id) throws NotFoundException;
    FacultyDto editFaculty(Long id, FacultyDto facultyDto) throws NotFoundException;
    Page<FacultyDto> getAll(Pageable pageable);
    FacultyDto getById(Long id) throws NotFoundException;
}
