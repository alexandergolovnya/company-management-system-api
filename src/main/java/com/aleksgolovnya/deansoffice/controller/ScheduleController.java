package com.aleksgolovnya.deansoffice.controller;

import com.aleksgolovnya.deansoffice.dto.ScheduleDto;
import com.aleksgolovnya.deansoffice.entity.Schedule;
import com.aleksgolovnya.deansoffice.repository.ScheduleRepository;
import com.aleksgolovnya.deansoffice.service.studying.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/schedule")
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;
    @Autowired
    private ScheduleRepository scheduleRepository;

    @GetMapping
    public List<Schedule> retrieveAllSchedules() {
        return scheduleService.getAll();
    }

    @GetMapping("/{id}")
    public Schedule retrieveSchedule(@PathVariable Long id) {
        Optional<Schedule> schedule = scheduleRepository.findById(id);
        return schedule.get();
    }

    @GetMapping("/lessons-count/{id}")
    public Long getTeacherWorkLoad(@PathVariable Long id) {
        Long workLoad = scheduleService.getTeacherWorkLoad(id);
        return workLoad;
    }

    @GetMapping("/lessons/{id}")
    public List<Schedule> getTeacherLessons(@PathVariable Long id) {
        List<Schedule> lessons = scheduleService.getTeacherLessons(id);
        return lessons;
    }

    @DeleteMapping("/{id}")
    public void deleteSchedule(@PathVariable Long id) {
        scheduleRepository.deleteById(id);
    }

    @PostMapping
    public Schedule addSchedule(@RequestBody ScheduleDto scheduleDto) {
        return scheduleService.addSchedule(scheduleDto);
    }

    @PutMapping("/{id}")
    public Schedule updateSchedule(@RequestBody ScheduleDto scheduleDto, @PathVariable Long id) {
        scheduleDto.setId(id);
        return scheduleService.editSchedule(scheduleDto);
    }
}
