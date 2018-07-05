package com.aleksgolovnya.deansoffice.controller;

import com.aleksgolovnya.deansoffice.entity.Student;
import com.aleksgolovnya.deansoffice.entity.Subject;
import com.aleksgolovnya.deansoffice.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class SubjectController {

    @Autowired
    private SubjectRepository subjectRepository;

    @GetMapping("/subjects")
    public List<Subject> retrieveAllSubjects() {
        return subjectRepository.findAll();
    }

    @GetMapping("/subjects/{id}")
    public Subject retrieveSubject(@PathVariable Long id) {
        Optional<Subject> subject = subjectRepository.findById(id);

        return subject.get();
    }

    @DeleteMapping("/subjects/{id}")
    public void deleteSubject(@PathVariable Long id) {
        subjectRepository.deleteById(id);
    }

    @PostMapping("/subjects")
    public ResponseEntity<Object> createSubject(@RequestBody Subject subject) {
        Subject savedSubject = subjectRepository.save(subject);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedSubject.getId()).toUri();

        return ResponseEntity.created(location).build();

    }

    @PutMapping("/subjects/{id}")
    public ResponseEntity<Object> updateSubject(@RequestBody Subject subject, @PathVariable Long id) {

        Optional<Subject> subjectOptional = subjectRepository.findById(id);

        if (!subjectOptional.isPresent())
            return ResponseEntity.notFound().build();

        subject.setId(id);
        subjectRepository.save(subject);
        return ResponseEntity.noContent().build();
    }
}
