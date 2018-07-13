package com.aleksgolovnya.deansoffice.controller;

import com.aleksgolovnya.deansoffice.entity.StudentsGroup;
import com.aleksgolovnya.deansoffice.repository.StudentsGroupRepository;
import com.aleksgolovnya.deansoffice.service.people.StudentsGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/groups")
public class StudentsGroupController {

    @Autowired
    private StudentsGroupRepository studentsGroupRepository;
    @Autowired
    private StudentsGroupService studentsGroupService;

    @GetMapping
    public List<StudentsGroup> getAllStudentsGroups() {
        return studentsGroupService.getAll();
    }

    @GetMapping("/{id}")
    public StudentsGroup getStudentsGroup(@PathVariable Long id) {
        StudentsGroup studentsGroup = studentsGroupService.getById(id);
        return studentsGroup;
    }

    @DeleteMapping("/{id}")
    public void deleteStudentsGroup(@PathVariable Long id) {
        studentsGroupRepository.deleteById(id);
    }

    @PostMapping
    public ResponseEntity<Object> createStudentsGroup(@RequestBody StudentsGroup studentsGroup) {
        StudentsGroup savedStudentsGroup = studentsGroupRepository.save(studentsGroup);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedStudentsGroup.getId()).toUri();

        return ResponseEntity.created(location).build();

    }

    @PutMapping("{id}")
    public ResponseEntity<Object> updateStudentsGroup(@RequestBody StudentsGroup studentsGroup, @PathVariable Long id) {

        Optional<StudentsGroup> studentsGroupOptional = studentsGroupRepository.findById(id);

        if (!studentsGroupOptional.isPresent())
            return ResponseEntity.notFound().build();

        studentsGroup.setId(id);
        studentsGroupRepository.save(studentsGroup);
        return ResponseEntity.noContent().build();
    }
}
