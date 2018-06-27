package com.aleksgolovnya.deansoffice.service;

import com.aleksgolovnya.deansoffice.entity.Department;
import com.aleksgolovnya.deansoffice.entity.Faculty;

import java.util.List;

public interface FacultyService {
    Faculty addDFaculty(Faculty faculty);
    void deleteFaculty(int id);
    Faculty editFaculty(Faculty faculty);
    List<Faculty> getAll();
}
