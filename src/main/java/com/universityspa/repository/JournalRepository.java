package com.universityspa.repository;

import com.universityspa.entity.Journal;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Implementation of JpaRepository for Journal entity
 */

public interface JournalRepository extends JpaRepository<Journal, Long> {

    /**
     * Select all journal records for student
     *
     * @param id of the student
     * @return List<Journal>
     */
    @Query("SELECT j FROM Journal j WHERE j.studentId=:id")
    Page<Journal> getJournalRecordsForStudent(@Param("id") Long id, Pageable pageable);

    /**
     * Select all lessons from journal which student have passed
     *
     * @param id of the student
     * @return List<Journal>
     */
    @Query("SELECT j FROM Journal j WHERE (j.studentId=:id) AND (j.mark = 'н')")
    Page<Journal> getStudentPasses(@Param("id") Long id, Pageable pageable);

    /**
     * Select all the number lessons from journal which student have passed
     *
     * @param id of the student
     * @return number of passed lessons
     */
    @Query("SELECT COUNT(j) FROM Journal j WHERE (j.studentId=:id) AND (j.mark = 'н')")
    Long getStudentPassesCount(@Param("id") Long id);

    /**
     * Select all marks of student from journal
     *
     * @param id of the student
     * @return List<Journal>
     */
    @Query("SELECT j FROM Journal j WHERE (j.studentId=:id) AND (j.mark IN('1', '2', '3', '4', '5'))")
    Page<Journal> getStudentMarks(@Param("id") Long id, Pageable pageable);

    /**
     * Get journal for the lesson in the schedule
     *
     * @param id of the journal
     * @return List<Journal>
     */
    @Query("SELECT j FROM Journal j WHERE j.scheduleId=:id")
    Page<Journal> getJournalForScheduleRecord(@Param("id") Long id, Pageable pageable);

    @Query("SELECT j FROM User j WHERE j.id=:id")
    Journal getOne(@Param("id") Long id);
}
