package com.aleksgolovnya.deansoffice.controller;

import com.aleksgolovnya.deansoffice.dto.TeacherDto;
import com.aleksgolovnya.deansoffice.entity.Teacher;
import com.aleksgolovnya.deansoffice.repository.TeacherRepository;
import com.aleksgolovnya.deansoffice.service.people.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/teachers")
public class TeacherController {

    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private TeacherService teacherService;


    @GetMapping
    public List<Teacher> retrieveAllTeachers() {
        return teacherRepository.findAll();
    }

    @GetMapping("/{id}")
    public Teacher retrieveTeacher(@PathVariable Long id) {
        Optional<Teacher> teacher = teacherRepository.findById(id);

        return teacher.get();
    }

    @DeleteMapping("/{id}")
    public void deleteTeacher(@PathVariable Long id) {
        teacherRepository.deleteById(id);
    }

    @PostMapping
    public Teacher createTeacher(@RequestBody TeacherDto teacherDto) {
        return teacherService.addTeacher(teacherDto);
    }

    @PutMapping("/{id}")
    public Teacher updateTeacher(@RequestBody TeacherDto teacherDto, @PathVariable Long id) {
        teacherDto.setId(id);
        return teacherService.editTeacher(teacherDto);
    }
}
