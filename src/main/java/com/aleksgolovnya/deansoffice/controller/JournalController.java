package com.aleksgolovnya.deansoffice.controller;

import com.aleksgolovnya.deansoffice.dto.JournalDto;
import com.aleksgolovnya.deansoffice.entity.Journal;
import com.aleksgolovnya.deansoffice.service.studying.JournalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

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
    public List<Journal> getAllJournalRecords() {
        return journalService.getAll();
    }

    /**
     * Method returns record of journal by id
     *
     * @param id of the journal
     * @return journal
     */
    @GetMapping("/{id}")
    public Journal getJournalRecord(@PathVariable Long id) {
        Journal journal = journalService.getById(id);
        return journal;
    }

    /**
     * Method returns all journal records of student by id
     * Include student marks and passes.
     *
     * @param id of the student
     * @return studentRecords
     */
    @GetMapping("/scores/{id}")
    public List<Journal> getAllJournalRecordsByStudent(@PathVariable Long id) {
        List<Journal> studentRecords = journalService.getStudentScores(id);
        return studentRecords;
    }

    /**
     * Method returns all passes of student by id
     *
     * @param id of the student
     * @return studentPasses
     */
    @GetMapping("/passes/{id}")
    public List<Journal> getStudentsPasses(@PathVariable Long id) {
        List<Journal> studentPasses = journalService.getStudentPasses(id);
        return studentPasses;
    }

    /**
     * Method returns the number of student passes
     *
     * @param id of the tudent
     * @return passesCount
     */
    @GetMapping("/passes-number/{id}")
    public Long getStudentsPassesCount(@PathVariable Long id) {
        Long passesCount = journalService.getStudentPassesCount(id);
        return passesCount;
    }

    /**
     * Method returns all marks of student by id
     *
     * @param id of the student
     * @return marks
     */
    @GetMapping("/marks/{id}")
    public List<Journal> getStudentsMarks(@PathVariable Long id) {
        List<Journal> marks = journalService.getStudentMarks(id);
        return marks;
    }

    /**
     * Method deletes record of journal by id
     *
     * @param id of the journal record
     */
    @DeleteMapping("/{id}")
    public void deleteJournalRecord(@PathVariable Long id) {
        journalService.deleteJournal(id);
    }

    /**
     * Method creates new record of journal
     *
     * @param journalDto
     * @return journal record
     */
    @PostMapping
    public Journal addJournalRecord(@RequestBody JournalDto journalDto) {
        return journalService.addJournal(journalDto);
    }

    /**
     * Method edits information of schedule journal by id
     *
     * @param journalDto
     * @param id of the journal
     * @return journal record
     */
    @PutMapping("/{id}")
    public Journal updateJournalRecord(@RequestBody JournalDto journalDto, @PathVariable Long id) {
        journalDto.setId(id);
        return journalService.editJournal(journalDto);
    }
}
