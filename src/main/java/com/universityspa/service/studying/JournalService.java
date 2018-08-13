package com.universityspa.service.studying;

import com.universityspa.dto.JournalDto;
import com.universityspa.entity.Journal;
import com.universityspa.exception.NotFoundException;
import com.universityspa.service.abstracts.CommonCrudService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

public interface JournalService extends CommonCrudService<Journal, JournalDto> {

    @PreAuthorize("hasAnyAuthority('TEACHER', 'ADMIN')")
    JournalDto addJournal(JournalDto journalDto);

    @PreAuthorize("hasAnyAuthority('TEACHER', 'ADMIN')")
    void deleteJournal(Long id) throws NotFoundException;

    @PreAuthorize("hasAnyAuthority('TEACHER', 'ADMIN')")
    JournalDto editJournal(Long id, JournalDto journal) throws NotFoundException;

    @PreAuthorize("hasAnyAuthority('TEACHER', 'STUDENT', 'ADMIN')")
    Page<JournalDto> getAll(Pageable pageable);

    @PreAuthorize("hasAnyAuthority('TEACHER', 'STUDENT', 'ADMIN')")
    JournalDto getById(Long id) throws NotFoundException;

    @PreAuthorize("hasAnyAuthority('TEACHER', 'STUDENT', 'ADMIN')")
    Page<JournalDto> getJournalRecordsForStudent(Long id, Pageable pageable);

    @PreAuthorize("hasAnyAuthority('TEACHER', 'STUDENT', 'ADMIN')")
    Page<JournalDto> getStudentPasses(Long id, Pageable pageable);

    @PreAuthorize("hasAnyAuthority('TEACHER', 'STUDENT', 'ADMIN')")
    Long getStudentPassesCount(Long id);

    @PreAuthorize("hasAnyAuthority('TEACHER', 'STUDENT', 'ADMIN')")
    Page<JournalDto> getStudentMarks(Long id, Pageable pageable);

    @PreAuthorize("hasAnyAuthority('TEACHER', 'STUDENT', 'ADMIN')")
    Page<JournalDto> getJournalForScheduleRecord(Long id, Pageable pageable);

}
