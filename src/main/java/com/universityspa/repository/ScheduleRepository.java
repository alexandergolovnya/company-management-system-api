package com.universityspa.repository;

import com.universityspa.entity.Schedule;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Implementation of JpaRepository for Schedule entity
 */

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

    /**
     * Select the number of teacher lessons from schedule
     *
     * @param id of the teacher
     * @return number of teacher lessons
     */
    @Query("SELECT COUNT(s) FROM Schedule s WHERE s.teacherId=:id")
    Long getTeacherWorkLoad(@Param("id") Long id);

    /**
     * Select all lessons for teacher from schedule
     *
     * @param id of the teacher
     * @return List<Schedule>
     */
    @Query("SELECT s FROM Schedule s WHERE s.teacherId=:id")
    Page<Schedule> getTeacherLessons(@Param("id") Long id, Pageable pageable);
}
