package com.universityspa.service.university;

import com.universityspa.dto.FacultyDto;
import com.universityspa.entity.Faculty;
import com.universityspa.exception.NotFoundException;
import com.universityspa.repository.FacultyRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
public class FacultyServiceImpl implements FacultyService {

    @Autowired
    private FacultyRepository facultyRepository;

    @Autowired
    private ModelMapper modelMapper;

    /**
     * Method creates new faculty
     * It takes DTO, converts it to entity
     * save entity to the database, converts entity to dto
     * and return dto-object
     *
     * @param facultyDto
     * @return FacultyDto
     */
    @Override
    public FacultyDto addFaculty(FacultyDto facultyDto) {
        Faculty facultyToCreate = convertToEntity(facultyDto);
        Faculty savedFaculty = facultyRepository.saveAndFlush(facultyToCreate);
        return convertToDto(savedFaculty);
    }

    /**
     * Method delete a faculty
     *
     * @param id of the faculty
     * @throws NotFoundException if faculty doesn't exist
     */
    @Override
    public void deleteFaculty(Long id) throws NotFoundException {
        Faculty deleteFaculty = facultyRepository.getOne(id);
        if (deleteFaculty != null) {
            facultyRepository.delete(deleteFaculty);
        } else {
            throw new NotFoundException("Unable to delete, faculty with such id doesn't exist");
        }
    }

    /**
     * Method edits information of the faculty
     * It takes DTO, converts it to entity
     * save entity to the database, converts entity to dto
     * and return dto-object
     *
     * @param id of the faculty
     * @param facultyDto
     * @return FacultyDto
     * @throws NotFoundException if faculty doesn't exist
     */
    @Override
    public FacultyDto editFaculty(Long id, FacultyDto facultyDto) throws NotFoundException {
        Faculty facultyToEdit = facultyRepository.getOne(id);
        if (facultyToEdit != null) {
            facultyToEdit = convertToEntity(facultyDto);
            Faculty savedFaculty = facultyRepository.saveAndFlush(facultyToEdit);
            return convertToDto(savedFaculty);
        } else {
            throw new NotFoundException("Unable to edit, faculty with such id doesn't exist");
        }
    }

    /**
     * Method returns all faculties with pagination
     *
     * @param pageable
     * @return Page<FacultyDto>
     */
    @Override
    public Page<FacultyDto> getAll(Pageable pageable) {
        Page<Faculty> facultyPage = facultyRepository.findAll(pageable);
        int totalElements = (int) facultyPage.getTotalElements();
        List<FacultyDto> facultyDtoList = facultyPage
                .getContent()
                .stream()
                .map(faculty -> convertToDto(faculty))
                .collect(Collectors.toList());

        Page<FacultyDto> facultyDtoPage = new PageImpl<>(facultyDtoList, pageable, totalElements);
        return facultyDtoPage;
    }

    /**
     * Method returns faculty by id
     *
     * @param id of the Faculty
     * @return FacultyDto
     * @throws NotFoundException if faculty doesn't exist
     */
    @Override
    public FacultyDto getById(Long id) throws NotFoundException {
        Faculty faculty = facultyRepository.getOne(id);
        if (faculty != null) {
            FacultyDto facultyDto = convertToDto(faculty);
            return facultyDto;
        } else {
            throw new NotFoundException("Faculty not found");
        }
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
        faculty.setId(facultyDto.getId());
        faculty.setName(facultyDto.getName());
        faculty.setDescription(facultyDto.getDescription());
        return faculty;
    }

    /**
     * Method of converting entity into the DTO
     * Uses ModelMapper library
     *
     * @param faculty
     * @return facultyDto
     */
    @Override
    public FacultyDto convertToDto(Faculty faculty) {
        FacultyDto facultyDto = modelMapper.map(faculty, FacultyDto.class);
        facultyDto.setId(faculty.getId());
        facultyDto.setName(faculty.getName());
        facultyDto.setDescription(faculty.getDescription());
        return facultyDto;
    }
}
