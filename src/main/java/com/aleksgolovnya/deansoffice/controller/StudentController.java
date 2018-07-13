package com.aleksgolovnya.deansoffice.controller;

import com.aleksgolovnya.deansoffice.dto.SpecialtyDto;
import com.aleksgolovnya.deansoffice.dto.StudentDto;
import com.aleksgolovnya.deansoffice.entity.Student;
import com.aleksgolovnya.deansoffice.repository.StudentRepository;
import com.aleksgolovnya.deansoffice.service.people.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private StudentService studentService;

    @GetMapping
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable Long id) {
        Optional<Student> student = studentRepository.findById(id);

        return student.get();
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }

    @PostMapping
    public Student createStudent(@RequestBody StudentDto studentDto) {
        return studentService.addStudent(studentDto);

    }

    @PutMapping("/{id}")
    public Student updateStudent(@RequestBody StudentDto studentDto, @PathVariable Long id) {
        studentDto.setId(id);
        return studentService.editStudent(studentDto);
    }
}
