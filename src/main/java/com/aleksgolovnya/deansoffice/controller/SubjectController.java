package com.aleksgolovnya.deansoffice.controller;

import com.aleksgolovnya.deansoffice.dto.SubjectDto;
import com.aleksgolovnya.deansoffice.entity.Subject;
import com.aleksgolovnya.deansoffice.entity.Teacher;
import com.aleksgolovnya.deansoffice.service.studying.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

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
     * Method returns all subjects
     *
     * @return [Subject]
     */
    @GetMapping
    public List<Subject> getAllSubjects() {
        return subjectService.getAll();
    }

    /**
     * Method returns subject by id
     *
     * @param id of the subject
     * @return subject
     */
    @GetMapping("/{id}")
    public Subject getSubject(@PathVariable Long id) {
        Subject subject = subjectService.getById(id);
        return subject;
    }

    /**
     * Method returns all teachers of this subject by id
     *
     * @param id of the subject
     * @return [Teacher]
     */
//    @GetMapping("/{id}/teachers")
//    public List<Teacher> getSubjectTeachers(@PathVariable Long id) {
//        List<Teacher> teachers = subjectService.getSubjectTeachers(id);
//        return teachers;
//    }

    /**
     * Method deletes subject by id
     *
     * @param id of the subject
     */
    @DeleteMapping("/{id}")
    public void deleteSubject(@PathVariable Long id) {
        subjectService.deleteSubject(id);
    }

    /**
     * Method creates new subject
     *
     * @param subjectDto
     * @return subject
     */
    @PostMapping
    public Subject createSubject(@RequestBody SubjectDto subjectDto) {
        return subjectService.addSubject(subjectDto);

    }

    /**
     * Method edits information of the subject by id
     *
     * @param subjectDto
     * @param id of the subject
     * @return subject
     */
    @PutMapping("{id}")
    public Subject updateSubject(@RequestBody SubjectDto subjectDto, @PathVariable Long id) {
        subjectDto.setId(id);
        return subjectService.editSubject(subjectDto);
    }
}
