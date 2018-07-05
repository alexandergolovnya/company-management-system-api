package com.aleksgolovnya.deansoffice.controller;

import com.aleksgolovnya.deansoffice.entity.Faculty;
import com.aleksgolovnya.deansoffice.repository.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "faculties")
public class FacultyController {

    @Autowired
    private FacultyRepository facultyRepository;

    @GetMapping
    public List<Faculty> retrieveAllFaculties() {
        return facultyRepository.findAll();
    }

    @GetMapping("/{id}")
    public Faculty retrieveFaculty(@PathVariable Long id) {
        Optional<Faculty> faculty = facultyRepository.findById(id);

        return faculty.get();
    }

    @DeleteMapping("/{id}")
    public void deleteFaculty(@PathVariable Long id) {
        facultyRepository.deleteById(id);
    }

    @PostMapping
    public ResponseEntity<Object> createFaculty(@RequestBody Faculty faculty) {
        Faculty savedFaculty = facultyRepository.save(faculty);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedFaculty.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Object> updateFaculty(@RequestBody Faculty faculty, @PathVariable Long id) {

        Optional<Faculty> facultyOptional = facultyRepository.findById(id);

        if (!facultyOptional.isPresent())
            return ResponseEntity.notFound().build();

        faculty.setId(id);
        facultyRepository.save(faculty);
        return ResponseEntity.noContent().build();
    }
}
