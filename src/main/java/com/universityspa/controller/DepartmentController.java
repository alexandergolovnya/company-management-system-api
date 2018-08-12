package com.universityspa.controller;

import com.universityspa.dto.DepartmentDto;
import com.universityspa.entity.Department;
import com.universityspa.entity.Specialty;
import com.universityspa.exception.NotFoundException;
import com.universityspa.service.university.DepartmentService;
import com.universityspa.service.university.SpecialtyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for a Department.
 * Provides CRUD operations.
 */

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private SpecialtyService specialtyService;

    /**
     * Method returns all departments with pagination
     *
     * @return Page<DepartmentDto>
     */
    @GetMapping
    public Page<DepartmentDto> getAllDepartments(Pageable pageable) {
        return departmentService.getAll(pageable);
    }

    /**
     * Method returns department by id
     *
     * @param id of the department
     * @return DepartmentDto
     * @throws NotFoundException if department doesn't exist
     */
    @GetMapping("/{id}")
    public DepartmentDto getDepartment(@PathVariable Long id) throws NotFoundException {
        return departmentService.getById(id);
    }

    /**
     * Method returns all specialties of this department
     *
     * @return [Specialty]
     */
    @GetMapping("/department/{id}")
    public List<Specialty> getDepartmentSpecialties(@PathVariable Long id) {
        return specialtyService.getDepartmentSpecialties(id);
    }

    /**
     * Method deletes department by id
     *
     * @param id of the department
     * @throws NotFoundException if department doesn't exist
     */
    @DeleteMapping("/{id}")
    public void deleteDepartment(@PathVariable Long id) throws NotFoundException {
        departmentService.deleteDepartment(id);
    }

    /**
     * Method creates new department
     *
     * @param departmentDto
     * @return DepartmentDto
     */
    @PostMapping
    public DepartmentDto createDepartment(@RequestBody DepartmentDto departmentDto) {
        return departmentService.addDepartment(departmentDto);
    }

    /**
     * Method edits information of department by id
     *
     * @param departmentDto
     * @param id of the department
     * @return DepartmentDto
     * @throws NotFoundException if department doesn't exist
     */
    @PutMapping("/{id}")
    public DepartmentDto updateDepartment(@RequestBody DepartmentDto departmentDto, @PathVariable Long id) throws NotFoundException {
        return departmentService.editDepartment(id, departmentDto);
    }
}
