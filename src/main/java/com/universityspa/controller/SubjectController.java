package com.universityspa.controller;

import com.universityspa.dto.SubjectDto;
import com.universityspa.exception.NotFoundException;
import com.universityspa.service.studying.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

/**
 * REST controller for a Subject.
 * Provides CRUD operations.
 */

@RestController
@RequestMapping("/api/subjects")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    /**
     * Method returns all subjects with pagination
     *
     * @return Page<SubjectDto>
     */
    @GetMapping
    private Page<SubjectDto> getAllSubjects(Pageable pageable) {
        return subjectService.getAll(pageable);
    }

    /**
     * Method returns subject by id
     *
     * @param id of the subject
     * @return subjectDto
     * @throws NotFoundException if subject doesn't exist
     */
    @GetMapping("/{id}")
    public SubjectDto getSubject(@PathVariable Long id) throws NotFoundException {
        return subjectService.getById(id);
    }

    /**
     * Method deletes subject by id
     *
     * @param id of the subject
     */
    @DeleteMapping("/{id}")
    public void deleteSubject(@PathVariable Long id) throws NotFoundException {
        subjectService.deleteSubject(id);
    }

    /**
     * Method creates new subject
     *
     * @param subjectDto
     * @return subjectDto
     */
    @PostMapping
    public SubjectDto createSubject(@RequestBody SubjectDto subjectDto) {
        return subjectService.addSubject(subjectDto);

    }

    /**
     * Method edits information of the subject by id
     *
     * @param subjectDto
     * @param id of the subject
     * @return subjectDto
     */
    @PutMapping("{id}")
    public SubjectDto updateSubject(@RequestBody SubjectDto subjectDto, @PathVariable Long id) throws NotFoundException {
        return subjectService.editSubject(id, subjectDto);
    }
}
