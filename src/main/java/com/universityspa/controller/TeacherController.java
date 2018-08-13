package com.universityspa.controller;

import com.universityspa.dto.ScheduleDto;
import com.universityspa.dto.TeacherDto;
import com.universityspa.exception.NotFoundException;
import com.universityspa.service.people.TeacherService;
import com.universityspa.service.studying.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

/**
 * REST controller for a Teacher.
 * Provides CRUD operations.
 */

@RestController
@RequestMapping("/api/teachers")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private ScheduleService scheduleService;

    /**
     * Method returns all teachers with pagination
     *
     * @return Page<TeacherDto>
     */
    @GetMapping
    public Page<TeacherDto> getAllTeachers(Pageable pageable) {
        return teacherService.getAll(pageable);
    }

    /**
     * Method returns teacher by id
     *
     * @param id of the teacher
     * @return TeacherDto
     * @throws NotFoundException if teacher doesn't exist
     */
    @GetMapping("/{id}")
    public TeacherDto getTeacher(@PathVariable Long id) throws NotFoundException {
        return teacherService.getById(id);
    }

    /**
     * Method returns all records from the schedule for this teacher by id with pagination
     *
     * @param id of the teacher
     * @return Page<ScheduleDto>
     */
    @GetMapping("/{id}/schedule")
    public Page<ScheduleDto> getTeachersSchedule(@PathVariable Long id, Pageable pageable) {
        return scheduleService.getTeacherLessons(id, pageable);
    }

    /**
     * Method deletes teacher by id
     *
     * @param id of the teacher
     * @throws NotFoundException if teacher doesn't exist
     */
    @DeleteMapping("/{id}")
    public void deleteTeacher(@PathVariable Long id) throws NotFoundException {
        teacherService.deleteTeacher(id);
    }

    /**
     * Method creates new teacher
     *
     * @param teacherDto
     * @return TeacherDto
     */
    @PostMapping
    public TeacherDto createTeacher(@RequestBody TeacherDto teacherDto) {
        return teacherService.addTeacher(teacherDto);
    }

    /**
     * Method edits information of the teacher by id
     *
     * @param teacherDto
     * @param id of the teacher
     * @return TeacherDto
     * @throws NotFoundException if teacher doesn't exist
     */
    @PutMapping("/{id}")
    public TeacherDto updateTeacher(@RequestBody TeacherDto teacherDto, @PathVariable Long id) throws NotFoundException {
        teacherDto.setId(id);
        return teacherService.editTeacher(id, teacherDto);
    }
}
