package com.universityspa.service.studying;

import com.universityspa.dto.ScheduleDto;
import com.universityspa.entity.Schedule;
import com.universityspa.exception.NotFoundException;
import com.universityspa.service.abstracts.CommonCrudService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ScheduleService extends CommonCrudService<Schedule, ScheduleDto> {
    ScheduleDto addSchedule(ScheduleDto scheduleDto);
    void deleteSchedule(Long id) throws NotFoundException;
    ScheduleDto editSchedule(Long id, ScheduleDto scheduleDto) throws NotFoundException;
    Page<ScheduleDto> getAll(Pageable pageable);
    ScheduleDto getById(Long id) throws NotFoundException;
    Long getTeacherWorkLoad(Long id);
    Page<ScheduleDto> getTeacherLessons(Long id, Pageable pageable);
}
