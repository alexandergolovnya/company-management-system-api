package com.aleksgolovnya.deansoffice.controller;

import com.aleksgolovnya.deansoffice.dto.JournalDto;
import com.aleksgolovnya.deansoffice.entity.Journal;
import com.aleksgolovnya.deansoffice.repository.JournalRepository;
import com.aleksgolovnya.deansoffice.service.subjects.JournalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/journal")
public class JournalController {

    @Autowired
    private JournalService journalService;
    @Autowired
    private JournalRepository journalRepository;

    @GetMapping
    public List<Journal> retrieveAllJournals() {
        return journalService.getAll();
    }

    @GetMapping("/{id}")
    public Journal retrieveJournal(@PathVariable Long id) {
        Optional<Journal> journal = journalRepository.findById(id);
        return journal.get();
    }

    @GetMapping("/marks/{id}")
    public List<Journal> getStudentsMarks(@PathVariable Long id) {
        List<Journal> marks = journalService.getStudentScores(id);
        return marks;
    }

    @DeleteMapping("/{id}")
    public void deleteJournal(@PathVariable Long id) {
        journalRepository.deleteById(id);
    }

    @PostMapping
    public Journal addJournal(@RequestBody JournalDto journalDto) {
        return journalService.addJournal(journalDto);
    }

    @PutMapping("/{id}")
    public Journal updateJournal(@RequestBody JournalDto journalDto, @PathVariable Long id) {
        journalDto.setId(id);
        return journalService.editJournal(journalDto);
    }
}
