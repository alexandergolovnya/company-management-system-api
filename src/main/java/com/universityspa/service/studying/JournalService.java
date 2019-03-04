package com.universityspa.service.studying;

import com.universityspa.dto.JournalDto;
import com.universityspa.entity.Journal;
import com.universityspa.exception.NotFoundException;
import com.universityspa.service.abstracts.CommonCrudService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;

public interface JournalService extends CommonCrudService<Journal, JournalDto> {

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    JournalDto addJournal(JournalDto journalDto);

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    void deleteJournal(Long id) throws NotFoundException;

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    JournalDto editJournal(Long id, JournalDto journal) throws NotFoundException;

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_USER')")
    Page<JournalDto> getAll(Pageable pageable);

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_USER')")
    JournalDto getById(Long id) throws NotFoundException;

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_USER')")
    Page<JournalDto> getJournalRecordsForStudent(Long id, Pageable pageable);

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_USER')")
    Page<JournalDto> getStudentPasses(Long id, Pageable pageable);

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_USER')")
    Long getStudentPassesCount(Long id);

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_USER')")
    Page<JournalDto> getStudentMarks(Long id, Pageable pageable);

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_USER')")
    Page<JournalDto> getJournalForScheduleRecord(Long id, Pageable pageable);

}
