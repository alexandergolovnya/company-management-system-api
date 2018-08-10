package com.universityspa.repository;

import com.universityspa.entity.Student;
import com.universityspa.entity.StudentsGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentsGroupRepository extends JpaRepository<StudentsGroup, Long> {

    StudentsGroup getById(Long id);

    /** Получить всех стдентов данной учебной группы */
    @Query("SELECT s FROM Student s WHERE s.groupId=:id")
    List<Student> getStudentGroupStudents(@Param("id") Long id);
}
