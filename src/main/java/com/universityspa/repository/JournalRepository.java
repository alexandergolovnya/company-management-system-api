package com.universityspa.repository;

import com.universityspa.entity.Journal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

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
    List<Journal> getJournalRecordsForStudent(@Param("id") Long id);

    /**
     * Select all lessons from journal which student have passed
     *
     * @param id of the student
     * @return List<Journal>
     */
    @Query("SELECT j FROM Journal j WHERE (j.studentId=:id) AND (j.mark = 'н')")
    List<Journal> getStudentPasses(@Param("id") Long id);

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
    List<Journal> getStudentMarks(@Param("id") Long id);

    /**
     * Get journal for the lesson in the schedule
     *
     * @param id of the journal
     * @return List<Journal>
     */
    @Query("SELECT j FROM Journal j WHERE j.scheduleId=:id")
    List<Journal> getJournalForScheduleRecord(@Param("id") Long id);
}
