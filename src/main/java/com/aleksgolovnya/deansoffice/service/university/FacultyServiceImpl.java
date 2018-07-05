package com.aleksgolovnya.deansoffice.service.university;

import com.aleksgolovnya.deansoffice.entity.Faculty;
import com.aleksgolovnya.deansoffice.repository.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacultyServiceImpl implements FacultyService {

    @Autowired
    private FacultyRepository facultyRepository;

    @Override
    public Faculty addDFaculty(Faculty faculty) {
        Faculty savedFaculty = facultyRepository.saveAndFlush(faculty);
        return savedFaculty;
    }

    @Override
    public void deleteFaculty(Long id) {
        Faculty deleteFaculty = facultyRepository.getOne(id);
        facultyRepository.delete(deleteFaculty);
    }

    @Override
    public Faculty editFaculty(Faculty faculty) {
        return facultyRepository.saveAndFlush(faculty);
    }

    @Override
    public List<Faculty> getAll() {
        return facultyRepository.findAll();
    }

    @Override
    public Faculty getById(Long id) {
        Faculty faculty = facultyRepository.getOne(id);
        return faculty;
    }
}
