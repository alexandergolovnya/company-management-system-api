package com.universityspa.repository;

import com.universityspa.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, Long> {

    Subject getById(Long id);

//    /** Получить все предметы данного преподавателя */
//    @Query("SELECT t FROM Teacher t " +
//            "INNER JOIN t.subjects ts " +
//            "WHERE ts.id=:id ")
//    List<Teacher> getSubjectTeachers(@Param("id") Long id);
}
