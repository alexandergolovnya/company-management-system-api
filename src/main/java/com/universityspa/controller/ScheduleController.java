package com.universityspa.controller;

import com.universityspa.dto.JournalDto;
import com.universityspa.dto.ScheduleDto;
import com.universityspa.exception.NotFoundException;
import com.universityspa.service.studying.JournalService;
import com.universityspa.service.studying.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

/**
 * REST controller for a Schedule.
 * Provides CRUD operations.
 */

@RestController
@RequestMapping("/api/schedule")
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;

    @Autowired
    private JournalService journalService;

    /**
     * Method returns all records of schedule with pagination
     *
     * @return Page<ScheduleDto>
     */
    @GetMapping
    public Page<ScheduleDto> getAllScheduleRecords(Pageable pageable) {
        return scheduleService.getAll(pageable);
    }

    /**
     * Method returns record of schedule by id
     *
     * @param id of the schedule
     * @return ScheduleDto
     * @throws NotFoundException if schedule doesn't exist
     */
    @GetMapping("/{id}")
    public ScheduleDto getScheduleRecord(@PathVariable Long id) throws NotFoundException {
        return scheduleService.getById(id);
    }

    /**
     * Method returns record of the journal for record in the schedule (lesson) by id with pagination
     *
     * @param id of the schedule
     * @return Page<JournalDto>
     */
    @GetMapping("/{id}/journal")
    public Page<JournalDto> getJournalForScheduleRecord(@PathVariable Long id, Pageable pageable) {
        return journalService.getJournalForScheduleRecord(id, pageable);
    }

    /**
     * Method returns the number of teachers lessons
     *
     * @param id of the teacher
     * @return workLoad
     */
    @GetMapping("/lessons-count/{id}")
    public Long getTeacherWorkLoad(@PathVariable Long id) {
        Long workLoad = scheduleService.getTeacherWorkLoad(id);
        return workLoad;
    }

    /**
     * Method returns the all teachers lessons with pagination
     *
     * @param id of the teacher
     * @return lessons
     */
    @GetMapping("/lessons/{id}")
    public Page<ScheduleDto> getTeacherLessons(@PathVariable Long id, Pageable pageable) {
        return scheduleService.getTeacherLessons(id, pageable);
    }

    /**
     * Method deletes record of schedule by id
     *
     * @param id of the schedule record
     * @throws NotFoundException if schedule doesn't exist
     */
    @DeleteMapping("/{id}")
    public void deleteScheduleRecord(@PathVariable Long id) throws NotFoundException {
        scheduleService.deleteSchedule(id);
    }

    /**
     * Method creates new record of schedule
     *
     * @param scheduleDto
     * @return ScheduleDto
     */
    @PostMapping
    public ScheduleDto createScheduleRecord(@RequestBody ScheduleDto scheduleDto) {
        return scheduleService.addSchedule(scheduleDto);
    }

    /**
     * Method edits information of schedule record by id
     *
     * @param scheduleDto
     * @param id of the schedule
     * @return ScheduleDto
     * @throws NotFoundException if schedule doesn't exist
     */
    @PutMapping("/{id}")
    public ScheduleDto updateScheduleRecord(@RequestBody ScheduleDto scheduleDto, @PathVariable Long id) throws NotFoundException {
        return scheduleService.editSchedule(id, scheduleDto);
    }
}
