package com.universityspa.service.studying;

import com.universityspa.dto.ScheduleDto;
import com.universityspa.entity.Journal;
import com.universityspa.entity.Schedule;

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
    List<Journal> getJournalForScheduleRecord(Long id);
}
