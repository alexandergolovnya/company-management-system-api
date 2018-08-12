package com.universityspa.service.university;

import com.universityspa.dto.DepartmentDto;
import com.universityspa.entity.Department;
import com.universityspa.exception.NotFoundException;
import com.universityspa.service.abstracts.CommonCrudService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DepartmentService extends CommonCrudService<Department, DepartmentDto> {

    DepartmentDto addDepartment(DepartmentDto department);
    void deleteDepartment(Long id) throws NotFoundException;
    DepartmentDto editDepartment(Long id, DepartmentDto department) throws NotFoundException;
    Page<DepartmentDto> getAll(Pageable pageable);
    DepartmentDto getById(Long id) throws NotFoundException;
    Page<DepartmentDto> getFacultyDepartments(Long id, Pageable pageable);
}
