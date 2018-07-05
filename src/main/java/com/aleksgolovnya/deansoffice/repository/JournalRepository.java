package com.aleksgolovnya.deansoffice.repository;

import com.aleksgolovnya.deansoffice.entity.Journal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface JournalRepository extends JpaRepository<Journal, Long> {

    Journal getById(Long id);

    /** Получить все записи журнала по студенту */
    @Query("SELECT j FROM Journal j WHERE j.studentId=:id")
    List<Journal> getStudentScores(@Param("id") Long id);

    /** Получить все пропущенные занятия студента */
    @Query("SELECT j FROM Journal j WHERE (j.studentId=:id) AND (j.mark = 'н')")
    List<Journal> getStudentPasses(@Param("id") Long id);

    /** Получить количество пропущенных занятий студента */
    @Query("SELECT COUNT(j) FROM Journal j WHERE (j.studentId=:id) AND (j.mark = 'н')")
    Long getStudentPassesCount(@Param("id") Long id);

    /** Получить все оценки студента */
    @Query("SELECT j FROM Journal j WHERE (j.studentId=:id) AND (j.mark IN('1', '2', '3', '4', '5'))")
    List<Journal> getStudentMarks(@Param("id") Long id);

//    /** Получить количество оценок студента */
//    @Query("SELECT COUNT(j) FROM Journal j WHERE (j.studentId=:id) AND (j.mark IN('1', '2', '3', '4', '5'))")
//    List<Journal> getStudentMarksCount(@Param("id") Long id);


}
