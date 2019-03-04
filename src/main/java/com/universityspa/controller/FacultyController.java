package com.universityspa.controller;

import com.universityspa.dto.DepartmentDto;
import com.universityspa.dto.FacultyDto;
import com.universityspa.exception.NotFoundException;
import com.universityspa.service.university.DepartmentService;
import com.universityspa.service.university.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

/**
 * REST controller for a Faculty.
 * Provides CRUD operations.
 */

@RestController
@RequestMapping("/api/faculties")
@CrossOrigin
public class FacultyController {

    private final FacultyService facultyService;
    private final DepartmentService departmentService;

    @Autowired
    public FacultyController(FacultyService facultyService, DepartmentService departmentService) {
        this.facultyService = facultyService;
        this.departmentService = departmentService;
    }

    /**
     * Method returns all faculties with pagination
     *
     * @return Page<FacultyDto>
     */
    @GetMapping
    public Page<FacultyDto> getAll(Pageable pageable) {
        return facultyService.getAll(pageable);
    }

    /**
     * Method returns faculty by id
     *
     * @param id of the faculty
     * @return faculty
     * @throws NotFoundException if faculty doesn't exist
     */
    @GetMapping("/{id}")
    public FacultyDto getFaculty(@PathVariable Long id) throws NotFoundException {
        return facultyService.getById(id);
    }

    /**
     * Method returns all departments for faculty
     *
     * @param id of the faculty
     * @return List<Department>
     */
    @GetMapping("/{id}/departments")
    public Page<DepartmentDto> getFacultyDepartments(@PathVariable Long id, Pageable pageable) {
        return departmentService.getFacultyDepartments(id, pageable);
    }

    /**
     * Method deletes faculty
     *
     * @param id of the faculty
     * @throws NotFoundException if faculty doesn't exist
     */
    @DeleteMapping("/{id}")
    public void deleteFaculty(@PathVariable Long id) throws NotFoundException {
        facultyService.deleteFaculty(id);
    }

    /**
     * Method creates new faculty
     *
     * @param facultyDto
     * @return FacultyDto
     */
    @PostMapping
    public FacultyDto createFaculty(@RequestBody FacultyDto facultyDto) {
        return facultyService.addFaculty(facultyDto);
    }

    /**
     * Method edits information of faculty by id
     *
     * @param facultyDto
     * @param id of the faculty
     * @return FacultyDto
     * @throws NotFoundException if faculty doesn't exist
     */
    @PutMapping("{id}")
    public FacultyDto updateFaculty(@RequestBody FacultyDto facultyDto, @PathVariable Long id) throws NotFoundException {
        facultyDto.setId(id);
        return facultyService.editFaculty(id, facultyDto);
    }
}
