package com.universityspa.service.university;

import com.universityspa.dto.DepartmentDto;
import com.universityspa.entity.Department;
import com.universityspa.exception.NotFoundException;
import com.universityspa.service.abstracts.CommonCrudService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;

public interface DepartmentService extends CommonCrudService<Department, DepartmentDto> {

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    DepartmentDto addDepartment(DepartmentDto department);

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    void deleteDepartment(Long id) throws NotFoundException;

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    DepartmentDto editDepartment(Long id, DepartmentDto department) throws NotFoundException;

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_USER')")
    Page<DepartmentDto> getAll(Pageable pageable);

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_USER')")
    DepartmentDto getById(Long id) throws NotFoundException;

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_USER')")
    Page<DepartmentDto> getFacultyDepartments(Long id, Pageable pageable);
}
