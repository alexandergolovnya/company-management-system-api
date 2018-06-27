package com.aleksgolovnya.deansoffice.repository;

import com.aleksgolovnya.deansoffice.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
}
