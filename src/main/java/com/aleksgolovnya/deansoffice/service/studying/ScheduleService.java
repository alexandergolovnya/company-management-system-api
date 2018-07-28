package com.aleksgolovnya.deansoffice.service.studying;

import com.aleksgolovnya.deansoffice.dto.ScheduleDto;
import com.aleksgolovnya.deansoffice.entity.Schedule;

import java.util.List;

public interface ScheduleService {
    Schedule addSchedule(ScheduleDto schedule);
    void deleteSchedule(Long id);
    Schedule editSchedule(ScheduleDto schedule);
    List<Schedule> getAll();
    Schedule getById(Long id);
    Schedule convertToEntity(ScheduleDto scheduleDto);
    Long getTeacherWorkLoad(Long id);
    List<Schedule> getTeacherLessons(Long id);
}
