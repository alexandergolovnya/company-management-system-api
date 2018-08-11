package com.universityspa.controller;

import com.universityspa.dto.StudentDto;
import com.universityspa.entity.Student;
import com.universityspa.repository.StudentRepository;
import com.universityspa.service.people.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    @Autowired
    private StudentRepository studentRepository;

    /**
     * Method returns all students
     *
     * @return [Student]
     */
    @GetMapping("/pageable")
    public Page<Student> getAllStudentsPageable(Pageable pageable) {
        return studentService.getAll(pageable);
    }
    @GetMapping
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    /**
     * Method returns student by id
     *
     * @param id of the student
     * @return student
     */
    @GetMapping("/{id}")
    public Student getStudent(@PathVariable Long id) {
        return studentService.getById(id);
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
