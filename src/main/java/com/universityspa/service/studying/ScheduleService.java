package com.universityspa.service.studying;

import com.universityspa.dto.ScheduleDto;
import com.universityspa.entity.Schedule;
import com.universityspa.exception.NotFoundException;
import com.universityspa.service.abstracts.CommonCrudService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;

public interface ScheduleService extends CommonCrudService<Schedule, ScheduleDto> {

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    ScheduleDto addSchedule(ScheduleDto scheduleDto);

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    void deleteSchedule(Long id) throws NotFoundException;

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    ScheduleDto editSchedule(Long id, ScheduleDto scheduleDto) throws NotFoundException;

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_USER')")
    Page<ScheduleDto> getAll(Pageable pageable);

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_USER')")
    ScheduleDto getById(Long id) throws NotFoundException;

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_USER')")
    Long getTeacherWorkLoad(Long id);

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_USER')")
    Page<ScheduleDto> getTeacherLessons(Long id, Pageable pageable);
}
