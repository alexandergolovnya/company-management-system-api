package com.aleksgolovnya.deansoffice.repository;

import com.aleksgolovnya.deansoffice.entity.Specialty;
import com.aleksgolovnya.deansoffice.entity.StudentsGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SpecialtyRepository extends JpaRepository<Specialty, Long> {

    Specialty getById(Long id);

    /** Получить все группы студентов для данной специальности */
    @Query("SELECT g FROM StudentsGroup g WHERE g.specialtyId=:id")
    List<StudentsGroup> getSpecialtyStudentGroups(@Param("id") Long id);
}
