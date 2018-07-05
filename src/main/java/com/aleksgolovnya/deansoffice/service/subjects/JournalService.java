package com.aleksgolovnya.deansoffice.service.subjects;

import com.aleksgolovnya.deansoffice.dto.JournalDto;
import com.aleksgolovnya.deansoffice.entity.Journal;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface JournalService {
    Journal addJournal(JournalDto journal);
    void deleteJournal(Long id);
    Journal editJournal(JournalDto journal);
    List<Journal> getAll();
    Journal getById(Long id);
    Journal convertToEntity(JournalDto journalDto);
    List<Journal> getStudentScores(Long id);
    List<Journal> getStudentPasses(Long id);
    Long getStudentPassesCount(Long id);
    List<Journal> getStudentMarks(Long id);


}
