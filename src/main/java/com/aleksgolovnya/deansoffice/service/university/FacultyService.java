package com.aleksgolovnya.deansoffice.service.university;

import com.aleksgolovnya.deansoffice.dto.FacultyDto;
import com.aleksgolovnya.deansoffice.entity.Department;
import com.aleksgolovnya.deansoffice.entity.Faculty;
import com.aleksgolovnya.deansoffice.service.CommonCrudService;

import java.util.List;

public interface FacultyService extends CommonCrudService<Faculty, FacultyDto> {
    Faculty addFaculty(FacultyDto facultyDto);
    void deleteFaculty(Long id);
    Faculty editFaculty(FacultyDto facultyDto);
    List<Faculty> getAll();
    Faculty getById(Long id);

    @Override
    default FacultyDto covertToDto(Faculty faculty) {
        throw new RuntimeException("Not implemented");
    }
}
