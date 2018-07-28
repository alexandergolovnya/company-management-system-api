package com.aleksgolovnya.deansoffice.repository;

import com.aleksgolovnya.deansoffice.entity.Student;
import com.aleksgolovnya.deansoffice.entity.StudentsGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentsGroupRepository extends JpaRepository<StudentsGroup, Long> {

    StudentsGroup getById(Long id);

    /** Получить все кафедры данного факультета */
    @Query("SELECT s FROM Student s WHERE s.groupId=:id")
    List<Student> getStudentGroupStudents(@Param("id") Long id);
}
