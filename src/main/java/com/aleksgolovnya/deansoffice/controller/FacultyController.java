package com.aleksgolovnya.deansoffice.controller;

import com.aleksgolovnya.deansoffice.dto.FacultyDto;
import com.aleksgolovnya.deansoffice.entity.Faculty;
import com.aleksgolovnya.deansoffice.service.university.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * REST controller for a Faculty.
 * Provides CRUD operations.
 */

@RestController
@RequestMapping("/api/faculties")
@CrossOrigin(origins = "http://localhost:8081")
public class FacultyController {

    @Autowired
    private FacultyService facultyService;

    /**
     * Method returns all faculties
     *
     * @return [Faculty]
     */
    @GetMapping
    public List<Faculty> getAllFaculties() {
        return facultyService.getAll();
    }

    /**
     * Method returns faculty by id
     *
     * @param id of the faculty
     * @return faculty
     */
    @GetMapping("/{id}")
    public Faculty getFaculty(@PathVariable Long id) {
        Faculty faculty = facultyService.getById(id);
        return faculty;
    }

    /**
     * Method deletes faculty by id
     *
     * @param id of the faculty
     */
    @DeleteMapping("/{id}")
    public void deleteFaculty(@PathVariable Long id) {
        facultyService.deleteFaculty(id);
    }

    /**
     * Method creates new faculty
     *
     * @param facultyDto
     * @return faculty
     */
    @PostMapping
    public Faculty createFaculty(@RequestBody FacultyDto facultyDto) {
        return facultyService.addFaculty(facultyDto);
    }

    /**
     * Method edits information of faculty by id
     *
     * @param facultyDto
     * @param id of the faculty
     * @return faculty
     */
    @PutMapping("{id}")
    public Faculty updateFaculty(@RequestBody FacultyDto facultyDto, @PathVariable Long id) {
        facultyDto.setId(id);
        return facultyService.editFaculty(facultyDto);
    }
}
