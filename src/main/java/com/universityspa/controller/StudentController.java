package com.universityspa.controller;

import com.universityspa.dto.StudentDto;
import com.universityspa.exception.NotFoundException;
import com.universityspa.service.people.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

/**
 * REST controller for a Student.
 * Provides CRUD operations.
 */

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    /**
     * Method returns all students with pagination
     *
     * @return studentDtoPage
     */
    @GetMapping
    public Page<StudentDto> getAllStudents(Pageable pageable) {
        return studentService.getAll(pageable);
    }

    /**
     * Method returns student by id
     *
     * @param id of the student
     * @return studentDto
     * @throws NotFoundException if student doesn't exist
     */
    @GetMapping("/{id}")
    public StudentDto getStudent(@PathVariable Long id) throws NotFoundException {
        return studentService.getById(id);
    }

    /**
     * Method deletes student by id
     *
     * @param id of the student
     * @throws NotFoundException if student doesn't exist
     */
    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) throws NotFoundException {
        studentService.deleteStudent(id);
    }

    /**
     * Method creates new student
     *
     * @param studentDto
     * @return studentDto
     */
    @PostMapping
    public StudentDto createStudent(@RequestBody StudentDto studentDto) {
        return studentService.addStudent(studentDto);

    }

    /**
     * Method edits information of student by id
     *
     * @param studentDto
     * @param id of the student
     * @return studentDto
     * @throws NotFoundException if student doesn't exist
     */
    @PutMapping("/{id}")
    public StudentDto updateStudent(@RequestBody StudentDto studentDto, @PathVariable Long id) throws NotFoundException {
        studentDto.setId(id);
        return studentService.editStudent(id, studentDto);
    }
}
