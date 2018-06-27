package com.aleksgolovnya.deansoffice.service;

import com.aleksgolovnya.deansoffice.entity.Department;

import java.util.List;

public interface DepartmentService {
    Department addDepartment(Department department);
    void deleteDepartment(int id);
    Department editDepartment(Department department);
    List<Department> getAll();
}
