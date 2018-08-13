package com.universityspa.service.studying;

import com.universityspa.dto.JournalDto;
import com.universityspa.entity.Journal;
import com.universityspa.exception.NotFoundException;
import com.universityspa.service.abstracts.CommonCrudService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface JournalService extends CommonCrudService<Journal, JournalDto> {

    JournalDto addJournal(JournalDto journalDto);
    void deleteJournal(Long id) throws NotFoundException;
    JournalDto editJournal(Long id, JournalDto journal) throws NotFoundException;
    Page<JournalDto> getAll(Pageable pageable);
    JournalDto getById(Long id) throws NotFoundException;
    Page<JournalDto> getJournalRecordsForStudent(Long id, Pageable pageable);
    Page<JournalDto> getStudentPasses(Long id, Pageable pageable);
    Long getStudentPassesCount(Long id);
    Page<JournalDto> getStudentMarks(Long id, Pageable pageable);
    Page<JournalDto> getJournalForScheduleRecord(Long id, Pageable pageable);

}
