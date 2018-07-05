package com.aleksgolovnya.deansoffice.controller;

import com.aleksgolovnya.deansoffice.dto.SpecialtyDto;
import com.aleksgolovnya.deansoffice.entity.Specialty;
import com.aleksgolovnya.deansoffice.repository.SpecialtyRepository;
import com.aleksgolovnya.deansoffice.service.university.SpecialtyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/specialties")
public class SpecialityController {

    @Autowired
    private SpecialtyRepository specialtyRepository;
    @Autowired
    private SpecialtyService specialtyService;

    @GetMapping
    public List<Specialty> retrieveAllSpecialties() {
        return specialtyRepository.findAll();
    }

    @GetMapping("/{id}")
    public Specialty retrieveSpecialty(@PathVariable Long id) {
        Optional<Specialty> specialty = specialtyRepository.findById(id);

        return specialty.get();
    }

    @DeleteMapping("/{id}")
    public void deleteSpecialty(@PathVariable Long id) {
        specialtyRepository.deleteById(id);
    }

    @PostMapping
    public Specialty createSpecialty(@RequestBody SpecialtyDto specialtyDto) {
        return specialtyService.addSpecialty(specialtyDto);
    }

    @PutMapping("/{id}")
    public Specialty updateSpecialty(@RequestBody SpecialtyDto specialtyDto, @PathVariable Long id) {
        specialtyDto.setId(id);
        return specialtyService.editSpecialty(specialtyDto);
    }
}
