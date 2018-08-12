package com.universityspa.service.studying;

import com.universityspa.dto.JournalDto;
import com.universityspa.entity.Journal;

import java.util.List;

public interface JournalService {
    Journal addJournal(JournalDto journal);
    void deleteJournal(Long id);
    Journal editJournal(JournalDto journal);
    List<Journal> getAll();
    Journal getById(Long id);
    Journal convertToEntity(JournalDto journalDto);
    List<Journal> getJournalRecordsForStudent(Long id);
    List<Journal> getStudentPasses(Long id);
    Long getStudentPassesCount(Long id);
    List<Journal> getStudentMarks(Long id);


}
