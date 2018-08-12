package com.universityspa.service.university;

import com.universityspa.dto.FacultyDto;
import com.universityspa.entity.Department;
import com.universityspa.entity.Faculty;
import com.universityspa.service.CommonCrudService;

import java.util.List;

public interface FacultyService extends CommonCrudService<Faculty, FacultyDto> {
    Faculty addFaculty(FacultyDto facultyDto);
    void deleteFaculty(Long id);
    Faculty editFaculty(FacultyDto facultyDto);
    List<Faculty> getAll();
    Faculty getById(Long id);
    List<Department> getFacultyDepartments(Long id);

    @Override
    default FacultyDto convertToDto(Faculty faculty) {
        throw new RuntimeException("Not implemented");
    }
}
