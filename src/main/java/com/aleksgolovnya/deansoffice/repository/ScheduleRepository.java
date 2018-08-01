package com.aleksgolovnya.deansoffice.repository;

import com.aleksgolovnya.deansoffice.entity.Journal;
import com.aleksgolovnya.deansoffice.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

    Schedule getById(Long id);

//    @Query("SELECT count() from schedule " +
//            "inner join teacher t on teacher_id = t.id " +
//            "where teacher_id = :id")
//    Optional<Schedule> getTeacherWorkLoad(@Param("id") Long id);

    @Query("SELECT COUNT(s) FROM Schedule s WHERE s.teacherId=:id")
    Long getTeacherWorkLoad(@Param("id") Long id);

    @Query("SELECT s FROM Schedule s WHERE s.teacherId=:id")
    List<Schedule> getTeacherLessons(@Param("id") Long id);

    /** Получить всех преподавателей данной кафедры */
    @Query("SELECT j FROM Journal j WHERE j.scheduleId=:id")
    List<Journal> getJournalForScheduleRecord(@Param("id") Long id);
}
