package com.universityspa.service.people;

import com.universityspa.dto.StudentDto;
import com.universityspa.entity.Student;
import com.universityspa.exception.NotFoundException;
import com.universityspa.repository.StudentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Service class for Student.
 * It contains implementation of CRUD operations
 * and entity-DTO conversion.
 *
 * It uses @link StudentRepository that extends JpaRepository
 * and ModelMapper library that provides methods
 * for entity-DTO conversion.
 */

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ModelMapper modelMapper;

    /**
     * Method creates new student
     * It takes DTO, converts it to entity
     * save entity to the database, converts entity to dto
     * and return dto-object
     *
     * @param studentDto
     * @return createdStudent
     */
    @Override
    public StudentDto addStudent(StudentDto studentDto) {
        Student studentToCreate = convertToEntity(studentDto);
        Student savedStudent = studentRepository.saveAndFlush(studentToCreate);
        return convertToDto(savedStudent);
    }

    /**
     * Method delete a student
     *
     * @param id of the student
     * @throws NotFoundException if student doesn't exist
     */
    @Override
    public void deleteStudent(Long id) throws NotFoundException {
        Student deleteStudent = studentRepository.getOne(id);
        if (deleteStudent != null) {
            studentRepository.delete(deleteStudent);
        } else {
            throw new NotFoundException("Unable to delete, student with such id doesn't exist");
        }
    }

    /**
     * Method edits information of the student
     * It takes DTO, converts it to entity
     * save entity to the database, converts entity to dto
     * and return dto-object
     *
     * @param id of the student
     * @param studentDto
     * @return editedStudent
     * @throws NotFoundException if student doesn't exist
     */
    @Override
    public StudentDto editStudent(Long id, StudentDto studentDto) throws NotFoundException {
        Student studentToEdit = studentRepository.getOne(id);
        if (studentToEdit != null) {
            studentToEdit = convertToEntity(studentDto);
            Student savedStudent = studentRepository.saveAndFlush(studentToEdit);
            StudentDto editedStudent = convertToDto(savedStudent);
            return editedStudent;
        } else {
            throw new NotFoundException("Unable to edit, student with such id doesn't exist");
        }
    }

    /**
     * Method returns all students with pagination
     *
     * @param pageable
     * @return studentDtoPage
     */
    @Override
    public Page<StudentDto> getAll(Pageable pageable) {
        Page<Student> studentPage = studentRepository.findAll(pageable);
        int totalElements = (int) studentPage.getTotalElements();
        List<StudentDto> studentDtoList = studentPage
                .getContent()
                .stream()
                .map(student -> convertToDto(student))
                .collect(Collectors.toList());

        Page<StudentDto> studentDtoPage = new PageImpl<>(studentDtoList, pageable, totalElements);
        return studentDtoPage;
    }

    /**
     * Method returns a student by id
     *
     * @param id of the student
     * @return studentDto
     * @throws NotFoundException if student doesn't exist
     */
    @Override
    public StudentDto getById(Long id) throws NotFoundException {
        Student student = studentRepository.getOne(id);
        if (student != null) {
            StudentDto studentDto = convertToDto(student);
            return studentDto;
        } else {
            throw new NotFoundException("Student not found");
        }
    }

    /**
     * Method returns all students for student group with pagination
     *
     * @param id of the student group
     * @param pageable
     * @return Page<StudentDto>
     */
    @Override
    public Page<StudentDto> getStudentGroupStudents(Long id, Pageable pageable) {
        Page<Student> studentPage = studentRepository.getStudentGroupStudents(id, pageable);
        int totalElements = (int) studentPage.getTotalElements();
        List<StudentDto> studentDtoList = studentPage
                .getContent()
                .stream()
                .map(student -> convertToDto(student))
                .collect(Collectors.toList());

        Page<StudentDto> studentDtoPage = new PageImpl<>(studentDtoList, pageable, totalElements);
        return studentDtoPage;
    }

    /**
     * Method of converting DTO into the entity
     * Uses ModelMapper library
     *
     * @param studentDto
     * @return student
     */
    @Override
    public Student convertToEntity(StudentDto studentDto) {
        Student student = modelMapper.map(studentDto, Student.class);
        student.setFirstName(studentDto.getFirstName());
        student.setLastName(studentDto.getLastName());
        student.setCourse(studentDto.getCourse());
        student.setGroupId(studentDto.getGroupId());
        return student;
    }

    /**
     * Method of converting entity into the DTO
     * Uses ModelMapper library
     *
     * @param student
     * @return studentDto
     */
    @Override
    public StudentDto convertToDto(Student student) {
        StudentDto studentDto = modelMapper.map(student, StudentDto.class);
        studentDto.setFirstName(student.getFirstName());
        studentDto.setLastName(student.getLastName());
        studentDto.setCourse(student.getCourse());
        studentDto.setGroupId(student.getGroupId());
        return studentDto;
    }
}
