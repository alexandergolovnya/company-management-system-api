package com.aleksgolovnya.deansoffice.controller;

import com.aleksgolovnya.deansoffice.dto.JournalDto;
import com.aleksgolovnya.deansoffice.entity.Journal;
import com.aleksgolovnya.deansoffice.repository.JournalRepository;
import com.aleksgolovnya.deansoffice.service.studying.JournalService;
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

    /** Получить все записи журнала */
    @GetMapping
    public List<Journal> retrieveAllJournals() {
        return journalService.getAll();
    }

    /** Получить конкретную запись журнала */
    @GetMapping("/{id}")
    public Journal retrieveJournal(@PathVariable Long id) {
        Optional<Journal> journal = journalRepository.findById(id);
        return journal.get();
    }

    /** Получить все записи студента по журналу */
    @GetMapping("/scores/{id}")
    public List<Journal> getStudentsScores(@PathVariable Long id) {
        List<Journal> scores = journalService.getStudentScores(id);
        return scores;
    }

    /** Получить все пропущенные занятия студента по журналу */
    @GetMapping("/passes/{id}")
    public List<Journal> getStudentsPasses(@PathVariable Long id) {
        List<Journal> passes = journalService.getStudentPasses(id);
        return passes;
    }

    /** Получить количетство пропущенных занятий студента по журналу */
    @GetMapping("/passes-number/{id}")
    public Long getStudentsPassesCount(@PathVariable Long id) {
        Long passesCount = journalService.getStudentPassesCount(id);
        return passesCount;
    }

    /** Получить все оценки студента по журналу */
    @GetMapping("/marks/{id}")
    public List<Journal> getStudentsMarks(@PathVariable Long id) {
        List<Journal> marks = journalService.getStudentMarks(id);
        return marks;
    }

    /** Удалить запись журнала */
    @DeleteMapping("/{id}")
    public void deleteJournal(@PathVariable Long id) {
        journalRepository.deleteById(id);
    }

    /** Добавить запись журнала */
    @PostMapping
    public Journal addJournal(@RequestBody JournalDto journalDto) {
        return journalService.addJournal(journalDto);
    }

    /** Обновить запись журнала */
    @PutMapping("/{id}")
    public Journal updateJournal(@RequestBody JournalDto journalDto, @PathVariable Long id) {
        journalDto.setId(id);
        return journalService.editJournal(journalDto);
    }
}
