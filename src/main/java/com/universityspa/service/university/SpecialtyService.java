package com.universityspa.service.university;

import com.universityspa.dto.SpecialtyDto;
import com.universityspa.entity.Specialty;
import com.universityspa.exception.NotFoundException;
import com.universityspa.service.abstracts.CommonCrudService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SpecialtyService extends CommonCrudService<Specialty, SpecialtyDto> {

    SpecialtyDto addSpecialty(SpecialtyDto specialty);
    void deleteSpecialty(Long id) throws NotFoundException;
    SpecialtyDto editSpecialty(Long id, SpecialtyDto specialty) throws NotFoundException;
    Page<SpecialtyDto> getAll(Pageable pageable);
    SpecialtyDto getById(Long id) throws NotFoundException;
    Page<SpecialtyDto> getDepartmentSpecialties(Long id, Pageable pageable);
}
