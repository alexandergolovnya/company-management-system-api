package com.aleksgolovnya.deansoffice.service;

import com.aleksgolovnya.deansoffice.entity.Schedule;

import java.util.List;

public interface ScheduleService {
    Schedule addSchedule(Schedule schedule);
    void deleteSchedule(int id);
    Schedule editSchedule(Schedule schedule);
    List<Schedule> getAll();
}
