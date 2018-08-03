package com.aleksgolovnya.deansoffice.repository;

import com.aleksgolovnya.deansoffice.entity.Schedule;
import com.aleksgolovnya.deansoffice.entity.Subject;
import com.aleksgolovnya.deansoffice.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    Teacher getById(Long id);

    /** Получить все предметы данного преподавателя */
//    @Query("SELECT s FROM Subject s " +
//            "INNER JOIN s.teachers ts " +
//            "WHERE ts.id=:id ")
//    List<Subject> getTeacherSubjects(@Param("id") Long id);

    /** Получить все предметы данного преподавателя */
    @Query("SELECT s FROM Subject s " +
            "INNER JOIN s.schedule sch ON sch.teacherId =:id " +
            "WHERE s.id = subjectId")
    List<Subject> getTeacherSubjects(@Param("id") Long id);

    /** Получить все записи из расписания для данного преподавателя */
    @Query("SELECT s FROM Schedule s WHERE s.teacherId=:id")
    List<Schedule> getTeachersSchedule(@Param("id") Long id);
}
