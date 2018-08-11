package com.universityspa.service.university;

import com.universityspa.dto.DepartmentDto;
import com.universityspa.entity.Department;
import com.universityspa.entity.Specialty;
import com.universityspa.entity.Teacher;

import java.util.List;

public interface DepartmentService {
    Department addDepartment(DepartmentDto department);
    void deleteDepartment(Long id);
    Department editDepartment(DepartmentDto department);
    List<Department> getAll();
    Department getById(Long id);
    Department convertToEntity(DepartmentDto departmentDto);
    List<Specialty> getDepartmentSpecialties(Long id);
    List<Teacher> getDepartmentTeachers(Long id);

}
