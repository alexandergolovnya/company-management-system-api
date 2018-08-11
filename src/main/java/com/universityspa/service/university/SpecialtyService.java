package com.universityspa.service.university;

import com.universityspa.dto.SpecialtyDto;
import com.universityspa.entity.Specialty;
import com.universityspa.entity.StudentsGroup;

import java.util.List;

public interface SpecialtyService {
    Specialty addSpecialty(SpecialtyDto specialty);
    void deleteSpecialty(Long id);
    Specialty editSpecialty(SpecialtyDto specialty);
    List<Specialty> getAll();
    Specialty getById(Long id);
    Specialty convertToEntity(SpecialtyDto specialtyDto);
    List<StudentsGroup> getSpecialtyStudentGroups(Long id);
}
