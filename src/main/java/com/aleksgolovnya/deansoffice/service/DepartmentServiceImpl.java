package com.aleksgolovnya.deansoffice.service;

import com.aleksgolovnya.deansoffice.entity.Department;
import com.aleksgolovnya.deansoffice.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department addDepartment(Department department) {
        Department savedDepartment =  departmentRepository.saveAndFlush(department);
        return savedDepartment;
    }

    @Override
    public void deleteDepartment(int id) {
        //departmentRepository.delete(id);
    }

    @Override
    public Department editDepartment(Department department) {
        return departmentRepository.saveAndFlush(department);
    }

    @Override
    public List<Department> getAll() {
        return departmentRepository.findAll();
    }
}
