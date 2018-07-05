package com.aleksgolovnya.deansoffice.controller;

import com.aleksgolovnya.deansoffice.dto.SubjectDto;
import com.aleksgolovnya.deansoffice.entity.Subject;
import com.aleksgolovnya.deansoffice.repository.SubjectRepository;
import com.aleksgolovnya.deansoffice.service.subjects.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/subjects")
public class SubjectController {

    @Autowired
    private SubjectRepository subjectRepository;
    @Autowired
    private SubjectService subjectService;

    @GetMapping
    public List<Subject> retrieveAllSubjects() {
        return subjectRepository.findAll();
    }

    @GetMapping("/{id}")
    public Subject retrieveSubject(@PathVariable Long id) {
        Optional<Subject> subject = subjectRepository.findById(id);

        return subject.get();
    }

    @DeleteMapping("/{id}")
    public void deleteSubject(@PathVariable Long id) {
        subjectRepository.deleteById(id);
    }

    @PostMapping
    public Subject createSubject(@RequestBody SubjectDto subjectDto) {
        return subjectService.addSubject(subjectDto);

    }

    @PutMapping("{id}")
    public Subject updateSubject(@RequestBody SubjectDto subjectDto, @PathVariable Long id) {
        subjectDto.setId(id);
        return subjectService.editSubject(subjectDto);
    }
}
