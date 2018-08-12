package com.universityspa.repository;

import com.universityspa.entity.Schedule;
import com.universityspa.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Implementation of JpaRepository for Teacher entity
 */

// TODO: 8/12/2018 fix the problem with dublicated method from schedule

public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    /**
     * (!) Duplicate of method from schedule
     * Select all lessons for teacher from schedule
     *
     * @param id of the teacher
     * @return List<Schedule>
     */
    @Query("SELECT s FROM Schedule s WHERE s.teacherId=:id")
    List<Schedule> getTeacherLessons(@Param("id") Long id);

    /**
     * Select all teeachers for this department
     *
     * @param id of ht department
     * @return List<Teacher>
     */
    @Query("SELECT t FROM Teacher t WHERE t.departmentId=:id")
    List<Teacher> getDepartmentTeachers(@Param("id") Long id);
}
