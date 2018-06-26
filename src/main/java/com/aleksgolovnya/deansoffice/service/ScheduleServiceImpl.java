package com.aleksgolovnya.deansoffice.service;

import com.aleksgolovnya.deansoffice.entity.Schedule;
import com.aleksgolovnya.deansoffice.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Override
    public Schedule addSchedule(Schedule schedule) {
        Schedule savedSchedule = scheduleRepository.saveAndFlush(schedule);
        return savedSchedule;
    }

    @Override
    public void deleteSchedule(int id) {

    }

    @Override
    public Schedule editSchedule(Schedule schedule) {
        return scheduleRepository.saveAndFlush(schedule);
    }

    @Override
    public List<Schedule> getAll() {
        return scheduleRepository.findAll();
    }
}
