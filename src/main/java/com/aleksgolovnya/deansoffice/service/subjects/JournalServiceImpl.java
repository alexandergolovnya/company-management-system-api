package com.aleksgolovnya.deansoffice.service.subjects;

import com.aleksgolovnya.deansoffice.dto.JournalDto;
import com.aleksgolovnya.deansoffice.entity.Journal;
import com.aleksgolovnya.deansoffice.repository.JournalRepository;
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

        journalToCreate.setScoreId(journalDto.getScoreId());
        journalToCreate.setStudentId(journalDto.getStudentId());
        journalToCreate.setSubjectId(journalDto.getSubjectId());
        journalToCreate.setDate(journalDto.getDate());

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
        journal.setScoreId(journalDto.getScoreId());
        journal.setStudentId(journalDto.getStudentId());
        journal.setSubjectId(journalDto.getSubjectId());
        journal.setDate(journalDto.getDate());
        return journal;
    }

    @Override
    public List<Journal> getStudentScores(Long id) {
        List<Journal> marks = journalRepository.getStudentScores(id);
        return marks;
    }
}
