package com.universityspa.repository;

import com.universityspa.entity.Student;
import com.universityspa.entity.StudentsGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Implementation of JpaRepository for Student Group entity
 */


public interface StudentsGroupRepository extends JpaRepository<StudentsGroup, Long> {

    /**
     * Select all students of this student group
     *
     * @param id of the student group
     * @return List<Student>
     */
    @Query("SELECT s FROM Student s WHERE s.groupId=:id")
    List<Student> getStudentGroupStudents(@Param("id") Long id);
}
