package com.universityspa.service.university;

import com.universityspa.dto.FacultyDto;
import com.universityspa.entity.Department;
import com.universityspa.entity.Faculty;
import com.universityspa.repository.FacultyRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

/**
 * Service class for Faculty.
 * It contains implementation of CRUD operations
 * and entity-DTO conversion.
 *
 * It uses @link FacultyRepository that extends JpaRepository
 * and ModelMapper library that provides methods
 * for entity-DTO conversion.
 */

@Service
@CrossOrigin(origins = "http://localhost:8081")
public class FacultyServiceImpl implements FacultyService {

    @Autowired
    private FacultyRepository facultyRepository;

    @Autowired
    private ModelMapper modelMapper;

    /**
     * Method creates new faculty
     * It takes DTO, converts it to entity
     * and returns entity
     *
     * @param facultyDto
     * @return savedFaculty
     */
    @Override
    public Faculty addFaculty(FacultyDto facultyDto) {
        Faculty facultyToCreate = convertToEntity(facultyDto);

        Faculty savedFaculty = facultyRepository.saveAndFlush(facultyToCreate);
        return savedFaculty;
    }

    /**
     * Method delete a faculty
     *
     * @param id of the faculty
     */
    @Override
    public void deleteFaculty(Long id) {
        Faculty deleteFaculty = facultyRepository.getOne(id);
        facultyRepository.delete(deleteFaculty);
    }

    /**
     * Method edits information of the faculty
     * It takes DTO, converts it to entity
     * and returns entity
     *
     * @param facultyDto
     * @return savedFaculty
     */
    @Override
    public Faculty editFaculty(FacultyDto facultyDto) {
        Faculty facultyToEdit = convertToEntity(facultyDto);

        Faculty savedFaculty = facultyRepository.saveAndFlush(facultyToEdit);
        return savedFaculty;
    }

    /**
     * Method receives all faculties
     *
     * @return [Faculty]
     */
    @Override
    public List<Faculty> getAll() {
        return facultyRepository.findAll();
    }

    /**
     * Method receives a faculty by id
     *
     * @param id of the Faculty
     * @return faculty
     */
    @Override
    public Faculty getById(Long id) {
        Faculty faculty = facultyRepository.getOne(id);
        return faculty;
    }

    /**
     * Method receives departments of this faculty
     *
     * @param id of the Faculty
     * @return facultyDepartments
     */
    @Override
    public List<Department> getFacultyDepartments(Long id) {
        List<Department> facultyDepartments = facultyRepository.getFacultyDepartments(id);
        return facultyDepartments;
    }

    /**
     * Method of converting DTO into the entity
     * Uses ModelMapper library
     *
     * @param facultyDto
     * @return faculty
     */
    @Override
    public Faculty convertToEntity(FacultyDto facultyDto) {
        Faculty faculty = modelMapper.map(facultyDto, Faculty.class);
        faculty.setName(facultyDto.getName());
        faculty.setDescription(facultyDto.getDescription());
        return faculty;
    }
}
