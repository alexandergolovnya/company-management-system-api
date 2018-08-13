package com.universityspa.controller;

import com.universityspa.dto.StudentDto;
import com.universityspa.dto.StudentsGroupDto;
import com.universityspa.exception.NotFoundException;
import com.universityspa.service.people.StudentService;
import com.universityspa.service.people.StudentsGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

/**
 * REST controller for a Student Group.
 * Provides CRUD operations.
 */

@RestController
@RequestMapping("/api/groups")
public class StudentsGroupController {

    @Autowired
    private StudentsGroupService studentsGroupService;

    @Autowired
    private StudentService studentService;

    /**
     * Method returns all student groups with pagination
     *
     * @return Page<StudentsGroupDto>
     */
    @GetMapping
    public Page<StudentsGroupDto> getAllStudentsGroups(Pageable pageable) {
        return studentsGroupService.getAll(pageable);
    }

    /**
     * Method returns student group by id
     *
     * @param id of the student group
     * @return StudentsGroupDto
     * @throws NotFoundException if student group doesn't exist
     */
    @GetMapping("/{id}")
    public StudentsGroupDto getStudentsGroup(@PathVariable Long id) throws NotFoundException {
        return studentsGroupService.getById(id);
    }

    /**
     * Method returns all students for this student group by id with pagination
     *
     * @param id of the student group
     * @return Page<StudentDto>
     */
    @GetMapping("/{id}/students")
    public Page<StudentDto> getStudentGroupStudents(@PathVariable Long id, Pageable pageable) {
        return studentService.getStudentGroupStudents(id, pageable);
    }

    /**
     * Method deletes student group by id
     * @param id of the student group
     * @throws NotFoundException if student group doesn't exist
     */
    @DeleteMapping("/{id}")
    public void deleteStudentsGroup(@PathVariable Long id) throws NotFoundException {
        studentsGroupService.deleteStudentsGroup(id);
    }

    /**
     * Method create new student group
     *
     * @param studentsGroupDto
     * @return StudentsGroupDto
     */
    @PostMapping
    public StudentsGroupDto createStudentsGroup(@RequestBody StudentsGroupDto studentsGroupDto) {
        return studentsGroupService.addStudentsGroup(studentsGroupDto);
    }

    /**
     * Method edits information of the student group by id
     * @param studentsGroupDto
     * @param id of the Student Group DTO
     * @return StudentsGroupDto
     * @throws NotFoundException if student group doesn't exist
     */
    @PutMapping("{id}")
    public StudentsGroupDto updateStudentsGroup(@RequestBody StudentsGroupDto studentsGroupDto, @PathVariable Long id) throws NotFoundException {
        studentsGroupDto.setId(id);
        return studentsGroupService.editStudentsGroup(id, studentsGroupDto);
    }
}
