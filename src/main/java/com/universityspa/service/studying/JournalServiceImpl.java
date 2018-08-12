package com.universityspa.service.studying;

import com.universityspa.dto.JournalDto;
import com.universityspa.entity.Journal;
import com.universityspa.repository.JournalRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JournalServiceImpl implements JournalService {

    @Autowired
    private JournalRepository journalRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Journal addJournal(JournalDto journalDto) {
        Journal journalToCreate = new Journal();

        journalToCreate.setStudentId(journalDto.getStudentId());
        journalToCreate.setScheduleId(journalDto.getScheduleId());
        journalToCreate.setMark(journalDto.getMark());

        Journal savedJournal = journalRepository.saveAndFlush(journalToCreate);
        return savedJournal;
    }

    @Override
    public void deleteJournal(Long id) {
        Journal deleteJournal = journalRepository.getOne(id);
        journalRepository.delete(deleteJournal);
    }

    @Override
    public Journal editJournal(JournalDto journalDto) {
        Journal journal = convertToEntity(journalDto);
        Journal savedJournal = journalRepository.saveAndFlush(journal);
        return savedJournal;
    }

    @Override
    public List<Journal> getAll() {
        return journalRepository.findAll();
    }

    @Override
    public Journal getById(Long id) {
        Journal journal = journalRepository.getOne(id);
        return journal;
    }

    @Override
    public Journal convertToEntity(JournalDto journalDto) {
        Journal journal = modelMapper.map(journalDto, Journal.class);
        journal.setStudentId(journalDto.getStudentId());
        journal.setScheduleId(journalDto.getScheduleId());
        journal.setMark(journalDto.getMark());
        return journal;
    }

    @Override
    public List<Journal> getJournalRecordsForStudent(Long id) {
        List<Journal> marks = journalRepository.getJournalRecordsForStudent(id);
        return marks;
    }

    @Override
    public List<Journal> getStudentPasses(Long id) {
        List<Journal> passes = journalRepository.getStudentPasses(id);
        return passes;
    }

    @Override
    public Long getStudentPassesCount(Long id) {
        Long passesCount = journalRepository.getStudentPassesCount(id);
        return passesCount;
    }

    @Override
    public List<Journal> getStudentMarks(Long id) {
        List<Journal> marks = journalRepository.getStudentMarks(id);
        return marks;
    }

    /**
     * Method receives all journal records for the record in the schedule (lesson)
     *
     * @param id of the schedule
     * @return [Journal]
     */
    @Override
    public List<Journal> getJournalForScheduleRecord(Long id) {
        List<Journal> journalRecords = journalRepository.getJournalForScheduleRecord(id);
        return journalRecords;
    }
}
