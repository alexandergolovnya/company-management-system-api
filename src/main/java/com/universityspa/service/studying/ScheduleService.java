package com.universityspa.service.studying;

import com.universityspa.dto.ScheduleDto;
import com.universityspa.entity.Schedule;
import com.universityspa.exception.NotFoundException;
import com.universityspa.service.abstracts.CommonCrudService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;

public interface ScheduleService extends CommonCrudService<Schedule, ScheduleDto> {

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    ScheduleDto addSchedule(ScheduleDto scheduleDto);

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    void deleteSchedule(Long id) throws NotFoundException;

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    ScheduleDto editSchedule(Long id, ScheduleDto scheduleDto) throws NotFoundException;

    @PreAuthorize("hasAnyAuthority('TEACHER', 'STUDENT', 'ADMIN')")
    Page<ScheduleDto> getAll(Pageable pageable);

    @PreAuthorize("hasAnyAuthority('TEACHER', 'STUDENT', 'ADMIN')")
    ScheduleDto getById(Long id) throws NotFoundException;

    @PreAuthorize("hasAnyAuthority('TEACHER', 'ADMIN')")
    Long getTeacherWorkLoad(Long id);

    @PreAuthorize("hasAnyAuthority('TEACHER', 'ADMIN')")
    Page<ScheduleDto> getTeacherLessons(Long id, Pageable pageable);
}
