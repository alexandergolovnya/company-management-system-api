package com.aleksgolovnya.deansoffice.service.university;

import com.aleksgolovnya.deansoffice.dto.SpecialtyDto;
import com.aleksgolovnya.deansoffice.entity.Specialty;
import com.aleksgolovnya.deansoffice.entity.StudentsGroup;

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
