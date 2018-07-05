package com.aleksgolovnya.deansoffice.controller;

import com.aleksgolovnya.deansoffice.entity.Teacher;
import com.aleksgolovnya.deansoffice.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class TeacherController {

    @Autowired
    private TeacherRepository teacherRepository;


    @GetMapping("/teachers")
    public List<Teacher> retrieveAllTeachers() {
        return teacherRepository.findAll();
    }

    @GetMapping("/teachers/{id}")
    public Teacher retrieveTeacher(@PathVariable Long id) {
        Optional<Teacher> teacher = teacherRepository.findById(id);

        return teacher.get();
    }

    @DeleteMapping("/teachers/{id}")
    public void deleteTeacher(@PathVariable Long id) {
        teacherRepository.deleteById(id);
    }

    @PostMapping("/teachers")
    public ResponseEntity<Object> createTeacher(@RequestBody Teacher teacher) {
        Teacher savedTeacher = teacherRepository.save(teacher);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedTeacher.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping("/teachers/{id}")
    public ResponseEntity<Object> updateTeacher(@RequestBody Teacher teacher, @PathVariable Long id) {

        Optional<Teacher> teacherOptional = teacherRepository.findById(id);

        if (!teacherOptional.isPresent())
            return ResponseEntity.notFound().build();

        teacher.setId(id);
        teacherRepository.save(teacher);
        return ResponseEntity.noContent().build();
    }
}
