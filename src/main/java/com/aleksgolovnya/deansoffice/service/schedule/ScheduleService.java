package com.aleksgolovnya.deansoffice.service.schedule;

import com.aleksgolovnya.deansoffice.dto.ScheduleDto;
import com.aleksgolovnya.deansoffice.entity.Schedule;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

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
