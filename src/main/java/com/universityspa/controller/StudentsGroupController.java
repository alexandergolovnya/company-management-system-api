package com.universityspa.controller;

import com.universityspa.dto.StudentsGroupDto;
import com.universityspa.entity.Student;
import com.universityspa.entity.StudentsGroup;
import com.universityspa.service.people.StudentsGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * REST controller for a Student Group.
 * Provides CRUD operations.
 */

@RestController
@RequestMapping("/api/groups")
public class StudentsGroupController {

    @Autowired
    private StudentsGroupService studentsGroupService;

    /**
     * Method returns all student groups
     *
     * @return [StudentsGroup]
     */
    @GetMapping
    public List<StudentsGroup> getAllStudentsGroups() {
        return studentsGroupService.getAll();
    }

    /**
     * Method returns student group by id
     *
     * @param id of the student group
     * @return studentsGroup
     */
    @GetMapping("/{id}")
    public StudentsGroup getStudentsGroup(@PathVariable Long id) {
        StudentsGroup studentsGroup = studentsGroupService.getById(id);
        return studentsGroup;
    }

    /**
     * Method returns all students for this student group by id
     *
     * @param id of the student group
     * @return [Student]
     */
    @GetMapping("/{id}/students")
    public List<Student> getStudentGroupStudents(@PathVariable Long id) {
        List<Student> students = studentsGroupService.getStudentGroupStudents(id);
        return students;
    }

    /**
     * Method deletes student group by id
     * @param id of the student group
     */
    @DeleteMapping("/{id}")
    public void deleteStudentsGroup(@PathVariable Long id) {
        studentsGroupService.deleteStudentsGroup(id);
    }

    /**
     * Method create new student group
     *
     * @param studentsGroupDto
     * @return studentsGroup
     */
    @PostMapping
    public StudentsGroup createStudentsGroup(@RequestBody StudentsGroupDto studentsGroupDto) {
        return studentsGroupService.addStudentsGroup(studentsGroupDto);
    }

    /**
     * Method edits information of the student group by id
     * @param studentsGroupDto
     * @param id of the Student Group DTO
     * @return studentsGroup
     */
    @PutMapping("{id}")
    public StudentsGroup updateStudentsGroup(@RequestBody StudentsGroupDto studentsGroupDto, @PathVariable Long id) {
        studentsGroupDto.setId(id);
        return studentsGroupService.editStudentsGroup(studentsGroupDto);
    }
}
