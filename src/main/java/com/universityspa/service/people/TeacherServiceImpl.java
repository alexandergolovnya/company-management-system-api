package com.universityspa.service.people;

import com.universityspa.dto.TeacherDto;
import com.universityspa.entity.Teacher;
import com.universityspa.exception.NotFoundException;
import com.universityspa.repository.TeacherRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Service class for Teacher.
 * It contains implementation of CRUD operations
 * and entity-DTO conversion.
 *
 * It uses @link TeacherRepository that extends JpaRepository
 * and ModelMapper library that provides methods
 * for entity-DTO conversion.
 */

@Service
public class TeacherServiceImpl implements  TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private ModelMapper modelMapper;

    /**
     * Method creates new teacher
     * It takes DTO, converts it to entity
     * save entity to the database, converts entity to dto
     * and return dto-object
     *
     * @param teacherDto
     * @return TeacherDto
     */
    @Override
    public TeacherDto addTeacher(TeacherDto teacherDto) {
        Teacher teacherToCreate = convertToEntity(teacherDto);
        Teacher savedTeacher = teacherRepository.saveAndFlush(teacherToCreate);
        return convertToDto(savedTeacher);
    }

    /**
     * Method deletes teacher
     *
     * @param id of the eacher
     * @throws NotFoundException if teacher doesn't exist
     */
    @Override
    public void deleteTeacher(Long id) throws NotFoundException {
        Teacher deleteTeacher = teacherRepository.getOne(id);
        if (deleteTeacher != null) {
            teacherRepository.delete(deleteTeacher);
        } else {
            throw new NotFoundException("Unable to delete, teacher with such id doesn't exist");
        }
    }

    /**
     * Method edits information of the teacher
     * It takes DTO, converts it to entity
     * save entity to the database, converts entity to dto
     * and return dto-object
     *
     * @param id of the teacher
     * @param teacherDto
     * @return TeacherDto
     * @throws NotFoundException if teacher doesn't exist
     */
    @Override
    public TeacherDto editTeacher(Long id, TeacherDto teacherDto) throws NotFoundException {
        Teacher teacherToEdit = teacherRepository.getOne(id);

        if (teacherToEdit != null) {
            teacherToEdit = convertToEntity(teacherDto);
            Teacher savedTeacher = teacherRepository.saveAndFlush(teacherToEdit);
            return convertToDto(savedTeacher);
        } else {
            throw new NotFoundException("Unable to edit, teacher with such id doesn't exist");
        }
    }

    /**
     * Method returns all teachers with pagination
     *
     * @param pageable
     * @return Page<TeacherDto>
     */
    @Override
    public Page<TeacherDto> getAll(Pageable pageable) {
        Page<Teacher> teacherPage = teacherRepository.findAll(pageable);
        int totalElements = (int) teacherPage.getTotalElements();
        List<TeacherDto> teacherDtoList = teacherPage
                .getContent()
                .stream()
                .map(teacher -> convertToDto(teacher))
                .collect(Collectors.toList());

        Page<TeacherDto> teacherDtoPage = new PageImpl<>(teacherDtoList, pageable, totalElements);
        return teacherDtoPage;
    }

    /**
     * Method returns teacher by id
     *
     * @param id of the teacher
     * @return TeacherDto
     * @throws NotFoundException if teacher doesn't exist
     */
    @Override
    public TeacherDto getById(Long id) throws NotFoundException {
        Teacher teacher = teacherRepository.getOne(id);
        if (teacher != null) {
            TeacherDto teacherDto = convertToDto(teacher);
            return teacherDto;
        } else {
            throw new NotFoundException("Student not found");
        }
    }

    /**
     * Method receives all teachers for department with pagination
     *
     * @param id of the department
     * @return Page<TeacherDto>
     */
    @Override
    public Page<TeacherDto> getDepartmentTeachers(Long id, Pageable pageable) {
        Page<Teacher> teacherPage = teacherRepository.getDepartmentTeachers(id, pageable);
        int totalElements = (int) teacherPage.getTotalElements();
        List<TeacherDto> teacherDtoList = teacherPage
                .getContent()
                .stream()
                .map(teacher -> convertToDto(teacher))
                .collect(Collectors.toList());

        Page<TeacherDto> teacherDtoPage = new PageImpl<>(teacherDtoList, pageable, totalElements);
        return teacherDtoPage;
    }

    /**
     * Method of converting DTO into the entity
     * Uses ModelMapper library
     *
     * @param teacherDto
     * @return teacher
     */
    @Override
    public Teacher convertToEntity(TeacherDto teacherDto) {
        Teacher teacher = modelMapper.map(teacherDto, Teacher.class);
        teacher.setId(teacher.getId());
        teacher.setFirstName(teacherDto.getFirstName());
        teacher.setLastName(teacherDto.getLastName());
        teacher.setPosition(teacherDto.getPosition());
        teacher.setDepartmentId(teacherDto.getDepartmentId());
        return teacher;
    }

    /**
     * Method of converting entity into the DTO
     * Uses ModelMapper library
     *
     * @param teacher
     * @return teacherDto
     */
    @Override
    public TeacherDto convertToDto(Teacher teacher) {
        TeacherDto teacherDto = modelMapper.map(teacher, TeacherDto.class);
        teacherDto.setId(teacher.getId());
        teacherDto.setFirstName(teacher.getFirstName());
        teacherDto.setLastName(teacher.getLastName());
        teacherDto.setPosition(teacher.getPosition());
        teacherDto.setDepartmentId(teacher.getDepartmentId());
        return teacherDto;
    }


}
