package com.universityspa.controller;

import com.universityspa.dto.SpecialtyDto;
import com.universityspa.dto.StudentsGroupDto;
import com.universityspa.exception.NotFoundException;
import com.universityspa.service.people.StudentsGroupService;
import com.universityspa.service.university.SpecialtyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

/**
 * REST controller for a Specialty.
 * Provides CRUD operations.
 */

@RestController
@RequestMapping("/api/specialties")
public class SpecialityController {

    @Autowired
    private SpecialtyService specialtyService;

    @Autowired
    private StudentsGroupService studentsGroupService;

    /**
     * Method returns all specialties with pagination
     *
     * @return Page<SpecialtyDto>
     */
    @GetMapping
    public Page<SpecialtyDto> getAllSpecialties(Pageable pageable) {
        return specialtyService.getAll(pageable);
    }

    /**
     * Method returns specialty by id
     *
     * @param id of the specialty
     * @return SpecialtyDto
     * @throws NotFoundException if specialty doesn't exist
     */
    @GetMapping("/{id}")
    public SpecialtyDto getSpecialty(@PathVariable Long id) throws NotFoundException {
        return specialtyService.getById(id);
    }

    /**
     * Method returns all student groups of this specialty with pagination
     *
     * @return Page<StudentsGroupDto>
     */
    @GetMapping("/{id}/student-groups")
    public Page<StudentsGroupDto> getSpecialtyStudentGroups(@PathVariable Long id, Pageable pageable) {
        return studentsGroupService.getSpecialtyStudentGroups(id, pageable);
    }

    /**
     * Method deletes specialty by id
     *
     * @param id of the specialty
     * @throws NotFoundException if specialty doesn't exist
     */
    @DeleteMapping("/{id}")
    public void deleteSpecialty(@PathVariable Long id) throws NotFoundException {
        specialtyService.deleteSpecialty(id);
    }

    /**
     * Method creates new specialty
     *
     * @param specialtyDto
     * @return SpecialtyDto
     */
    @PostMapping
    public SpecialtyDto createSpecialty(@RequestBody SpecialtyDto specialtyDto) {
        return specialtyService.addSpecialty(specialtyDto);
    }

    /**
     * Method edits information of specialty by id
     *
     * @param specialtyDto
     * @param id of the specialty
     * @return SpecialtyDto
     * @throws NotFoundException if specialty doesn't exist
     */
    @PutMapping("/{id}")
    public SpecialtyDto updateSpecialty(@RequestBody SpecialtyDto specialtyDto, @PathVariable Long id) throws NotFoundException {
        specialtyDto.setId(id);
        return specialtyService.editSpecialty(id, specialtyDto);
    }
}
