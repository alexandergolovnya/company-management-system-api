package com.aleksgolovnya.deansoffice.controller;

import com.aleksgolovnya.deansoffice.dto.DepartmentDto;
import com.aleksgolovnya.deansoffice.entity.Department;
import com.aleksgolovnya.deansoffice.repository.DepartmentRepository;
import com.aleksgolovnya.deansoffice.service.university.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private DepartmentService departmentService;

    @GetMapping
    public List<Department> retrieveAllDepartments() {
        return departmentRepository.findAll();
    }

    @GetMapping("/{id}")
    public Department retrieveDepartment(@PathVariable Long id) {
        Optional<Department> department = departmentRepository.findById(id);
        return department.get();
    }

    @DeleteMapping("/{id}")
    public void deleteDepartment(@PathVariable Long id) {
        departmentRepository.deleteById(id);
    }

    @PostMapping
    public Department createDepartment(@RequestBody DepartmentDto departmentDto) {
        return departmentService.addDepartment(departmentDto);
    }

    @PutMapping("/{id}")
    public Department updateDepartment(@RequestBody DepartmentDto departmentDto, @PathVariable Long id) {
        departmentDto.setId(id);
        return departmentService.editDepartment(departmentDto);
    }
}
