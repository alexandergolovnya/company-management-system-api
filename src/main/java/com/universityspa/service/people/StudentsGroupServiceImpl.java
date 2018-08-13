package com.universityspa.service.people;

import com.universityspa.dto.StudentsGroupDto;
import com.universityspa.entity.Student;
import com.universityspa.entity.StudentsGroup;
import com.universityspa.exception.NotFoundException;
import com.universityspa.repository.StudentsGroupRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Service class for StudentsGroup.
 * It contains implementation of CRUD operations
 * and entity-DTO conversion.
 *
 * It uses @link StudentsGroupRepository that extends JpaRepository
 * and ModelMapper library that provides methods
 * for entity-DTO conversion.
 */

@Service
public class StudentsGroupServiceImpl implements StudentsGroupService {

    @Autowired
    private StudentsGroupRepository studentsGroupRepository;

    @Autowired
    private ModelMapper modelMapper;

    /**
     * Method creates new student group
     * It takes DTO, converts it to entity
     * save entity to the database, converts entity to dto
     * and return dto-object
     *
     * @param studentsGroupDto
     * @return StudentsGroupDto
     */
    @Override
    public StudentsGroupDto addStudentsGroup(StudentsGroupDto studentsGroupDto) {
        StudentsGroup studentsGroupToCreate = convertToEntity(studentsGroupDto);
        StudentsGroup savedStudentsGroup = studentsGroupRepository.saveAndFlush(studentsGroupToCreate);
        return convertToDto(savedStudentsGroup);
    }

    /**
     * Method delete a student group
     *
     * @param id of the student group
     * @throws NotFoundException if student group doesn't exist
     */
    @Override
    public void deleteStudentsGroup(Long id) throws NotFoundException {
        StudentsGroup deleteStudentsGroup = studentsGroupRepository.getOne(id);
        if (deleteStudentsGroup != null) {
            studentsGroupRepository.delete(deleteStudentsGroup);
        } else {
            throw new NotFoundException("Unable to delete, student group with such id doesn't exist");
        }
    }

    /**
     * Method edits information of the student group
     * It takes DTO, converts it to entity
     * save entity to the database, converts entity to dto
     * and return dto-object
     *
     * @param id of the student group
     * @param studentsGroupDto
     * @return StudentsGroupDto
     * @throws NotFoundException if student group doesn't exist
     */
    @Override
    public StudentsGroupDto editStudentsGroup(Long id, StudentsGroupDto studentsGroupDto) throws NotFoundException {
        StudentsGroup studentsGroupToEdit = studentsGroupRepository.getOne(id);
        if (studentsGroupToEdit != null) {
            studentsGroupToEdit = convertToEntity(studentsGroupDto);
            StudentsGroup savedStudentsGroup = studentsGroupRepository.saveAndFlush(studentsGroupToEdit);
            StudentsGroupDto editedStudentsGroup = convertToDto(savedStudentsGroup);
            return editedStudentsGroup;
        } else {
            throw new NotFoundException("Unable to edit, student group with such id doesn't exist");
        }
    }

    /**
     * Method returns all student groups with pagination
     *
     * @param pageable
     * @return Page<StudentsGroupDto>
     */
    @Override
    public Page<StudentsGroupDto> getAll(Pageable pageable) {
        Page<StudentsGroup> studentsGroupPage = studentsGroupRepository.findAll(pageable);
        int totalElements = (int) studentsGroupPage.getTotalElements();
        List<StudentsGroupDto> studentsGroupDtoList = studentsGroupPage
                .getContent()
                .stream()
                .map(studentsGroup -> convertToDto(studentsGroup))
                .collect(Collectors.toList());

        Page<StudentsGroupDto> studentsGroupDtoPage = new PageImpl<>(studentsGroupDtoList, pageable, totalElements);
        return studentsGroupDtoPage;
    }

    /**
     * Method returns a student group by id
     *
     * @param id of the Student group
     * @return StudentsGroupDto
     */
    @Override
    public StudentsGroupDto getById(Long id) throws NotFoundException {
        StudentsGroup studentsGroup = studentsGroupRepository.getOne(id);
        if (studentsGroup != null) {
            StudentsGroupDto studentsGroupDto = convertToDto(studentsGroup);
            return studentsGroupDto;
        } else {
            throw new NotFoundException("Student Group not found");
        }
    }

    /**
     * Method returns all student groups for specialty with pagination
     *
     * @param id of the Specialty
     * @return specialtyStudentGroups
     */
    @Override
    public Page<StudentsGroupDto> getSpecialtyStudentGroups(Long id, Pageable pageable) {
        Page<StudentsGroup> studentsGroupPage = studentsGroupRepository.getSpecialtyStudentGroups(id, pageable);
        int totalElements = (int) studentsGroupPage.getTotalElements();
        List<StudentsGroupDto> studentsGroupDtoList = studentsGroupPage
                .getContent()
                .stream()
                .map(studentsGroup -> convertToDto(studentsGroup))
                .collect(Collectors.toList());

        Page<StudentsGroupDto> studentsGroupDtoPage = new PageImpl<>(studentsGroupDtoList, pageable, totalElements);
        return studentsGroupDtoPage;
    }

    /**
     * Method of converting DTO into the entity
     * Uses ModelMapper library
     *
     * @param studentsGroupDto
     * @return studentsGroup
     */
    @Override
    public StudentsGroup convertToEntity(StudentsGroupDto studentsGroupDto) {
        StudentsGroup studentsGroup = modelMapper.map(studentsGroupDto, StudentsGroup.class);
        studentsGroup.setGroupName(studentsGroupDto.getGroupName());
        studentsGroup.setSpecialtyId(studentsGroupDto.getSpecialtyId());
        return studentsGroup;
    }

    /**
     * Method of converting entity into the DTO
     * Uses ModelMapper library
     *
     * @param studentsGroup
     * @return studentsGroupDto
     */
    @Override
    public StudentsGroupDto convertToDto(StudentsGroup studentsGroup) {
        StudentsGroupDto studentsGroupDto = modelMapper.map(studentsGroup, StudentsGroupDto.class);
        studentsGroupDto.setId(studentsGroup.getId());
        studentsGroupDto.setGroupName(studentsGroup.getGroupName());
        studentsGroupDto.setSpecialtyId(studentsGroup.getSpecialtyId());
        return studentsGroupDto;
    }
}
