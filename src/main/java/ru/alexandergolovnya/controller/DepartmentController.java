package ru.alexandergolovnya.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import ru.alexandergolovnya.domain.dto.DepartmentDto;
import ru.alexandergolovnya.domain.dto.UserDto;
import ru.alexandergolovnya.exception.NotFoundException;
import ru.alexandergolovnya.service.auth.UserService;
import ru.alexandergolovnya.service.company.DepartmentService;

/**
 * REST controller for a Department.
 * Provides CRUD operations.
 *
 * @author: Alexander Golovnya <mail@alexandergolovnya.ru>
 * @created: 2019/09/04
 */
@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    private final DepartmentService departmentService;
    private final UserService userService;

    @Autowired
    public DepartmentController(DepartmentService departmentService, UserService userService) {
        this.departmentService = departmentService;
        this.userService = userService;
    }

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
     * @return DepartmentDtoф
     * @throws NotFoundException if department doesn't exist
     */
    @GetMapping("/{id}")
    public DepartmentDto getDepartment(@PathVariable int id) throws NotFoundException {
        return departmentService.getById(id);
    }

    /**
     * Method returns all employees for department with pagination
     *
     * @param id of the department
     * @return list of employees from this department
     */
    @GetMapping("/{id}/employees")
    public Page<UserDto> getDepartmentEmployees(@PathVariable int id, Pageable pageable) {
        return userService.getDepartmentEmployees(id, pageable);
    }

    /**
     * Method deletes department by id
     *
     * @param id of the department
     * @throws NotFoundException if department doesn't exist
     */
    @DeleteMapping("/{id}")
    public void deleteDepartment(@PathVariable int id) throws NotFoundException {
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
    public DepartmentDto updateDepartment(@RequestBody DepartmentDto departmentDto, @PathVariable int id) throws NotFoundException {
        departmentDto.setId(id);
        return departmentService.editDepartment(id, departmentDto);
    }
}
