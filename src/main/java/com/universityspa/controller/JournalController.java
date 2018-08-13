package com.universityspa.controller;

import com.universityspa.dto.JournalDto;
import com.universityspa.exception.NotFoundException;
import com.universityspa.service.studying.JournalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

/**
 * REST controller for a Journal.
 * Provides CRUD operations.
 */

@RestController
@RequestMapping("/api/journal")
public class JournalController {

    @Autowired
    private JournalService journalService;

    /**
     * Method returns all records of journal
     *
     * @return [Journal]
     */
    @GetMapping
    public Page<JournalDto> getAllJournalRecords(Pageable pageable) {
        return journalService.getAll(pageable);
    }

    /**
     * Method returns record of journal by id
     *
     * @param id of the journal
     * @return JournalDto
     * @throws NotFoundException if journal doesn't exist
     */
    @GetMapping("/{id}")
    public JournalDto getJournalRecord(@PathVariable Long id) throws NotFoundException {
        return journalService.getById(id);
    }

    /**
     * Method returns all journal records of student by id with pagination
     * Include student marks and passes.
     *
     * @param id of the student
     * @return Page<JournalDto>
     */
    @GetMapping("/scores/{id}")
    public Page<JournalDto> getAllJournalRecordsByStudent(@PathVariable Long id, Pageable pageable) {
        return journalService.getJournalRecordsForStudent(id, pageable);
    }

    /**
     * Method returns all passes of student by id with pagination
     *
     * @param id of the student
     * @return Page<JournalDto>
     */
    @GetMapping("/passes/{id}")
    public Page<JournalDto> getStudentsPasses(@PathVariable Long id, Pageable pageable) {
        return journalService.getStudentPasses(id, pageable);
    }

    /**
     * Method returns the number of student passes
     *
     * @param id of the student
     * @return passesCount
     */
    @GetMapping("/passes-number/{id}")
    public Long getStudentsPassesCount(@PathVariable Long id) {
        Long passesCount = journalService.getStudentPassesCount(id);
        return passesCount;
    }

    /**
     * Method returns all marks of student by id with pagination
     *
     * @param id of the student
     * @return marks
     */
    @GetMapping("/marks/{id}")
    public Page<JournalDto> getStudentsMarks(@PathVariable Long id, Pageable pageable) {
        return journalService.getStudentMarks(id, pageable);
    }

    /**
     * Method deletes record of journal by id
     *
     * @param id of the journal record
     * @throws NotFoundException if journal doesn't exist
     */
    @DeleteMapping("/{id}")
    public void deleteJournalRecord(@PathVariable Long id) throws NotFoundException {
        journalService.deleteJournal(id);
    }

    /**
     * Method creates new record of journal
     *
     * @param journalDto
     * @return JournalDto
     */
    @PostMapping
    public JournalDto addJournalRecord(@RequestBody JournalDto journalDto) {
        return journalService.addJournal(journalDto);
    }

    /**
     * Method edits information of schedule journal by id
     *
     * @param journalDto
     * @param id of the journal
     * @return JournalDto
     * @throws NotFoundException if journal doesn't exist
     */
    @PutMapping("/{id}")
    public JournalDto updateJournalRecord(@RequestBody JournalDto journalDto, @PathVariable Long id) throws NotFoundException {
        journalDto.setId(id);
        return journalService.editJournal(id, journalDto);
    }
}
