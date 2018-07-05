package com.aleksgolovnya.deansoffice.service.university;

import com.aleksgolovnya.deansoffice.dto.DepartmentDto;
import com.aleksgolovnya.deansoffice.entity.Department;

import java.util.List;

public interface DepartmentService {
    Department addDepartment(DepartmentDto department);
    void deleteDepartment(Long id);
    Department editDepartment(DepartmentDto department);
    List<Department> getAll();
    Department getById(Long id);
    Department convertToEntity(DepartmentDto departmentDto);

}
