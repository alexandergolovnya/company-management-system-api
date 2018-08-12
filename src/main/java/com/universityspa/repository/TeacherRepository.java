package com.universityspa.repository;

import com.universityspa.entity.Schedule;
import com.universityspa.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    Teacher getById(Long id);

    /** Получить все записи из расписания для данного преподавателя */
    @Query("SELECT s FROM Schedule s WHERE s.teacherId=:id")
    List<Schedule> getTeachersSchedule(@Param("id") Long id);
}
