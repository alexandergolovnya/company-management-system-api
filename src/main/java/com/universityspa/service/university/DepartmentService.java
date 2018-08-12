package com.universityspa.service.university;

import com.universityspa.dto.DepartmentDto;
import com.universityspa.entity.Department;
import com.universityspa.exception.NotFoundException;
import com.universityspa.service.abstracts.CommonCrudService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;

public interface DepartmentService extends CommonCrudService<Department, DepartmentDto> {

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    DepartmentDto addDepartment(DepartmentDto department);

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    void deleteDepartment(Long id) throws NotFoundException;

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    DepartmentDto editDepartment(Long id, DepartmentDto department) throws NotFoundException;

    @PreAuthorize("hasAnyAuthority('TEACHER', 'STUDENT', 'ADMIN')")
    Page<DepartmentDto> getAll(Pageable pageable);

    @PreAuthorize("hasAnyAuthority('TEACHER', 'STUDENT', 'ADMIN')")
    DepartmentDto getById(Long id) throws NotFoundException;

    @PreAuthorize("hasAnyAuthority('TEACHER', 'STUDENT', 'ADMIN')")
    Page<DepartmentDto> getFacultyDepartments(Long id, Pageable pageable);
}
