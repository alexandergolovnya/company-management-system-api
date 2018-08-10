package com.universityspa.service.people;

import com.universityspa.dto.StudentsGroupDto;
import com.universityspa.entity.Student;
import com.universityspa.entity.StudentsGroup;
import com.universityspa.repository.StudentsGroupRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

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
     * and returns entity
     *
     * @param studentsGroupDto
     * @return savedStudentsGroup
     */
    @Override
    public StudentsGroup addStudentsGroup(StudentsGroupDto studentsGroupDto) {
        StudentsGroup studentsGroupToCreate = convertToEntity(studentsGroupDto);

        StudentsGroup savedStudentsGroup = studentsGroupRepository.saveAndFlush(studentsGroupToCreate);
        return savedStudentsGroup;
    }

    /**
     * Method delete a student group
     *
     * @param id of the student group
     */
    @Override
    public void deleteStudentsGroup(Long id) {
        StudentsGroup deleteStudentsGroup = studentsGroupRepository.getOne(id);
        studentsGroupRepository.delete(deleteStudentsGroup);
    }

    /**
     * Method edits information of the student group
     * It takes DTO, converts it to entity
     * and returns entity
     *
     * @param studentsGroupDto
     * @return savedStudentsGroup
     */
    @Override
    public StudentsGroup editStudentsGroup(StudentsGroupDto studentsGroupDto) {
        StudentsGroup studentsGroupToEdit = convertToEntity(studentsGroupDto);

        StudentsGroup savedStudentsGroup = studentsGroupRepository.saveAndFlush(studentsGroupToEdit);
        return savedStudentsGroup;
    }

    /**
     * Method receives all student groups
     *
     * @return [StudentsGroup]
     */
    @Override
    public List<StudentsGroup> getAll() {
        return studentsGroupRepository.findAll();
    }

    /**
     * Method receives a student group by id
     *
     * @param id of the Student group
     * @return studentsGroup
     */
    @Override
    public StudentsGroup getById(Long id) {
        StudentsGroup studentsGroup = studentsGroupRepository.getOne(id);
        return studentsGroup;
    }

    /**
     * Method receives all students for this student group
     *
     * @param id of the student group
     * @return students
     */
    @Override
    public List<Student> getStudentGroupStudents(Long id) {
        List<Student> students = studentsGroupRepository.getStudentGroupStudents(id);
        return students;
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
}
