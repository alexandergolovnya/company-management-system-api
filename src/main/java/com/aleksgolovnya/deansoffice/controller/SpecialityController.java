package com.aleksgolovnya.deansoffice.controller;

import com.aleksgolovnya.deansoffice.dto.SpecialtyDto;
import com.aleksgolovnya.deansoffice.entity.Specialty;
import com.aleksgolovnya.deansoffice.entity.StudentsGroup;
import com.aleksgolovnya.deansoffice.service.university.SpecialtyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * REST controller for a Specialty.
 * Provides CRUD operations.
 */

@RestController
@RequestMapping("/api/specialties")
public class SpecialityController {

    @Autowired
    private SpecialtyService specialtyService;

    /**
     * Method returns all specialties
     *
     * @return [Specialty]
     */
    @GetMapping
    public List<Specialty> getAllSpecialties() {
        return specialtyService.getAll();
    }

    /**
     * Method returns specialty by id
     *
     * @param id of the specialty
     * @return specialty
     */
    @GetMapping("/{id}")
    public Specialty getSpecialty(@PathVariable Long id) {
        Specialty specialty = specialtyService.getById(id);
        return specialty;
    }

    /**
     * Method returns all student groups of this specialty
     *
     * @return [StudentsGroup]
     */
    @GetMapping("/{id}/student-groups")
    public List<StudentsGroup> getSpecialtyStudentGroups(@PathVariable Long id) {
        return specialtyService.getSpecialtyStudentGroups(id);
    }

    /**
     * Method deletes specialty by id
     *
     * @param id of the specialty
     */
    @DeleteMapping("/{id}")
    public void deleteSpecialty(@PathVariable Long id) {
        specialtyService.deleteSpecialty(id);
    }

    /**
     * Method creates new specialty
     *
     * @param specialtyDto
     * @return specialty
     */
    @PostMapping
    public Specialty createSpecialty(@RequestBody SpecialtyDto specialtyDto) {
        return specialtyService.addSpecialty(specialtyDto);
    }

    /**
     * Method edits information of specialty by id
     *
     * @param specialtyDto
     * @param id of the specialty
     * @return specialty
     */
    @PutMapping("/{id}")
    public Specialty updateSpecialty(@RequestBody SpecialtyDto specialtyDto, @PathVariable Long id) {
        specialtyDto.setId(id);
        return specialtyService.editSpecialty(specialtyDto);
    }
}
