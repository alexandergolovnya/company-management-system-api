package com.aleksgolovnya.deansoffice.service;

import com.aleksgolovnya.deansoffice.entity.Faculty;
import com.aleksgolovnya.deansoffice.repository.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class FacultyServiceImpl implements FacultyService {

    @Autowired
    private FacultyRepository facultyRepository;

    @Override
    public Faculty addDFaculty(Faculty faculty) {
        Faculty savedFaculty = facultyRepository.saveAndFlush(faculty);
        return savedFaculty;
    }

    @Override
    public void deleteFaculty(int id) {

    }

    @Override
    public Faculty editFaculty(Faculty faculty) {
        return facultyRepository.saveAndFlush(faculty);
    }

    @Override
    public List<Faculty> getAll() {
        return facultyRepository.findAll();
    }
}
