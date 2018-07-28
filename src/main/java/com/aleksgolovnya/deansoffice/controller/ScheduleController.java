package com.aleksgolovnya.deansoffice.controller;

import com.aleksgolovnya.deansoffice.dto.ScheduleDto;
import com.aleksgolovnya.deansoffice.entity.Schedule;
import com.aleksgolovnya.deansoffice.service.studying.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * REST controller for a Schedule.
 * Provides CRUD operations.
 */

@RestController
@RequestMapping("/api/schedule")
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;

    /**
     * Method returns all records of schedule
     *
     * @return [Schedule]
     */
    @GetMapping
    public List<Schedule> getAllScheduleRecords() {
        return scheduleService.getAll();
    }

    /**
     * Method returns record of schedule by id
     *
     * @param id of the schedule
     * @return schedule
     */
    @GetMapping("/{id}")
    public Schedule getScheduleRecord(@PathVariable Long id) {
        Schedule schedule = scheduleService.getById(id);
        return schedule;
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
     * Method returns the all teachers lessons
     *
     * @param id of the teacher
     * @return lessons
     */
    @GetMapping("/lessons/{id}")
    public List<Schedule> getTeacherLessons(@PathVariable Long id) {
        List<Schedule> lessons = scheduleService.getTeacherLessons(id);
        return lessons;
    }

    /**
     * Method deletes record of schedule by id
     *
     * @param id of the schedule record
     */
    @DeleteMapping("/{id}")
    public void deleteScheduleReord(@PathVariable Long id) {
        scheduleService.deleteSchedule(id);
    }

    /**
     * Method creates new record of schedule
     *
     * @param scheduleDto
     * @return schedule
     */
    @PostMapping
    public Schedule createScheduleRecord(@RequestBody ScheduleDto scheduleDto) {
        return scheduleService.addSchedule(scheduleDto);
    }

    /**
     * Method edits information of schedule record by id
     *
     * @param scheduleDto
     * @param id of the schedule
     * @return schedule
     */
    @PutMapping("/{id}")
    public Schedule updateScheduleRecord(@RequestBody ScheduleDto scheduleDto, @PathVariable Long id) {
        scheduleDto.setId(id);
        return scheduleService.editSchedule(scheduleDto);
    }
}
