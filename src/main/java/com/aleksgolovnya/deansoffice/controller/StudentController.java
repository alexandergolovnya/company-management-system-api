package com.aleksgolovnya.deansoffice.controller;

import com.aleksgolovnya.deansoffice.dto.StudentDto;
import com.aleksgolovnya.deansoffice.entity.Student;
import com.aleksgolovnya.deansoffice.service.people.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

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
     * Method returns all students
     *
     * @return [Student]
     */
    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAll();
    }

    /**
     * Method returns all students
     *
     * @param id of the student
     * @return student
     */
    @GetMapping("/{id}")
    public Student getStudent(@PathVariable Long id) {
        Student student = studentService.getById(id);
        return student;
    }

    /**
     * Method deletes student by id
     *
     * @param id of the student
     */
    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }

    /**
     * Method creates new student
     *
     * @param studentDto
     * @return student
     */
    @PostMapping
    public Student createStudent(@RequestBody StudentDto studentDto) {
        return studentService.addStudent(studentDto);

    }

    /**
     * Method edits information of student by id
     *
     * @param studentDto
     * @param id of the student
     * @return student
     */
    @PutMapping("/{id}")
    public Student updateStudent(@RequestBody StudentDto studentDto, @PathVariable Long id) {
        studentDto.setId(id);
        return studentService.editStudent(studentDto);
    }
}
