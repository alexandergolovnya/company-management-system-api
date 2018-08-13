package com.universityspa.service.studying;

import com.universityspa.dto.JournalDto;
import com.universityspa.entity.Journal;
import com.universityspa.exception.NotFoundException;
import com.universityspa.repository.JournalRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JournalServiceImpl implements JournalService {

    @Autowired
    private JournalRepository journalRepository;
    @Autowired
    private ModelMapper modelMapper;

    /**
     * Method creates new record of journal
     * It takes DTO, converts it to entity
     * save entity to the database, converts entity to dto
     * and return dto-object
     *
     * @param journalDto
     * @return JournalDto
     */
    @Override
    public JournalDto addJournal(JournalDto journalDto) {
        Journal journalToCreate = convertToEntity(journalDto);
        Journal savedJournal = journalRepository.saveAndFlush(journalToCreate);
        return convertToDto(savedJournal);
    }

    /**
     * Method deletes record of journal
     *
     * @param id of the journal
     * @throws NotFoundException if journal doesn't exist
     */
    @Override
    public void deleteJournal(Long id) throws NotFoundException {
        Journal deleteJournal = journalRepository.getOne(id);
        if (deleteJournal != null) {
            journalRepository.delete(deleteJournal);
        } else {
            throw new NotFoundException("Unable to delete, subject with such id doesn't exist");
        }
    }

    /**
     * Method edits information of the journal
     * It takes DTO, converts it to entity
     * save entity to the database, converts entity to dto
     * and return dto-object
     *
     * @param id of the journal
     * @param journalDto
     * @return JournalDto
     * @throws NotFoundException if journal doesn't exist
     */
    @Override
    public JournalDto editJournal(Long id, JournalDto journalDto) throws NotFoundException {
        Journal journalToEdit = journalRepository.getOne(id);

        if (journalToEdit != null) {
            journalToEdit = convertToEntity(journalDto);
            Journal savedJournal = journalRepository.saveAndFlush(journalToEdit);
            return convertToDto(savedJournal);
        } else {
            throw new NotFoundException("Unable to edit, subject with such id doesn't exist");
        }
    }

    /**
     * Method returns all record of journal with pagination
     *
     * @param pageable
     * @return Page<JournalDto>
     */
    @Override
    public Page<JournalDto> getAll(Pageable pageable) {
        Page<Journal> journalPage = journalRepository.findAll(pageable);
        int totalElements = (int) journalPage.getTotalElements();
        List<JournalDto> journalDtoList = journalPage
                .getContent()
                .stream()
                .map(journal -> convertToDto(journal))
                .collect(Collectors.toList());

        Page<JournalDto> journalDtoPage = new PageImpl<>(journalDtoList, pageable, totalElements);
        return journalDtoPage;
    }

    /**
     * Method returns journal by id
     *
     * @param id of the journal
     * @return JournalDto
     * @throws NotFoundException if journal doesn't exist
     */
    @Override
    public JournalDto getById(Long id) throws NotFoundException {
        Journal journal = journalRepository.getOne(id);
        if (journal != null) {
            return convertToDto(journal);
        } else {
            throw new NotFoundException("Subject not found");
        }
    }

    /**
     * Method returns all records from journal for student with pagination
     *
     * @param id of the student
     * @param pageable
     * @return Page<JournalDto> - records for student
     */
    @Override
    public Page<JournalDto> getJournalRecordsForStudent(Long id, Pageable pageable) {
        Page<Journal> journalPage = journalRepository.getJournalRecordsForStudent(id, pageable);
        int totalElements = (int) journalPage.getTotalElements();
        List<JournalDto> journalDtoList = journalPage
                .getContent()
                .stream()
                .map(journal -> convertToDto(journal))
                .collect(Collectors.toList());

        Page<JournalDto> journalDtoPage = new PageImpl<>(journalDtoList, pageable, totalElements);
        return journalDtoPage;
    }

    /**
     * Method returns all lessons from journal that student have passed with pagination
     *
     * @param id of the student
     * @param pageable
     * @return Page<JournalDto> - student passes
     */
    @Override
    public Page<JournalDto> getStudentPasses(Long id, Pageable pageable) {
        Page<Journal> journalPage = journalRepository.getStudentPasses(id, pageable);
        int totalElements = (int) journalPage.getTotalElements();
        List<JournalDto> journalDtoList = journalPage
                .getContent()
                .stream()
                .map(journal -> convertToDto(journal))
                .collect(Collectors.toList());

        Page<JournalDto> journalDtoPage = new PageImpl<>(journalDtoList, pageable, totalElements);
        return journalDtoPage;
    }

    /**
     * Method returns the number of student passes
     * @param id of the student
     * @return Long
     */
    @Override
    public Long getStudentPassesCount(Long id) {
        Long passesCount = journalRepository.getStudentPassesCount(id);
        return passesCount;
    }

    /**
     * Method returns all records from journal for student that contains student marks with pagination
     * @param id of the student
     * @param pageable
     * @return Page<JournalDto> - student marks
     */
    @Override
    public Page<JournalDto> getStudentMarks(Long id, Pageable pageable) {
        Page<Journal> journalPage = journalRepository.getStudentMarks(id, pageable);
        int totalElements = (int) journalPage.getTotalElements();
        List<JournalDto> journalDtoList = journalPage
                .getContent()
                .stream()
                .map(journal -> convertToDto(journal))
                .collect(Collectors.toList());

        Page<JournalDto> journalDtoPage = new PageImpl<>(journalDtoList, pageable, totalElements);
        return journalDtoPage;
    }

    /**
     * Method receives all journal records for the record in the schedule (lesson) with pagination
     *
     * @param id of the schedule
     * @return Page<JournalDto>
     */
    @Override
    public Page<JournalDto> getJournalForScheduleRecord(Long id, Pageable pageable) {
        Page<Journal> journalPage = journalRepository.getJournalForScheduleRecord(id, pageable);
        int totalElements = (int) journalPage.getTotalElements();
        List<JournalDto> journalDtoList = journalPage
                .getContent()
                .stream()
                .map(journal -> convertToDto(journal))
                .collect(Collectors.toList());

        Page<JournalDto> journalDtoPage = new PageImpl<>(journalDtoList, pageable, totalElements);
        return journalDtoPage;
    }

    /**
     * Method of converting DTO into the entity
     * Uses ModelMapper library
     *
     * @param journalDto
     * @return journal
     */
    @Override
    public Journal convertToEntity(JournalDto journalDto) {
        Journal journal = modelMapper.map(journalDto, Journal.class);
        journal.setStudentId(journalDto.getStudentId());
        journal.setScheduleId(journalDto.getScheduleId());
        journal.setMark(journalDto.getMark());
        return journal;
    }

    /**
     * Method of converting entity into the DTO
     * Uses ModelMapper library
     *
     * @param journal
     * @return journalDto
     */
    @Override
    public JournalDto convertToDto(Journal journal) {
        JournalDto journalDto = modelMapper.map(journal, JournalDto.class);
        journalDto.setId(journal.getId());
        journalDto.setMark(journal.getMark());
        journalDto.setScheduleId(journal.getScheduleId());
        journalDto.setStudentId(journal.getStudentId());
        return journalDto;
    }
}
