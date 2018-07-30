package com.aleksgolovnya.deansoffice.service.people;

import com.aleksgolovnya.deansoffice.dto.StudentDto;
import com.aleksgolovnya.deansoffice.entity.Student;
import com.aleksgolovnya.deansoffice.repository.StudentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

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
@CrossOrigin(origins = "http://localhost:8081")
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ModelMapper modelMapper;

    /**
     * Method creates new student
     * It takes DTO, converts it to entity
     * and returns entity
     *
     * @param studentDto
     * @return savedStudent
     */
    @Override
    public Student addStudent(StudentDto studentDto) {
        Student studentToCreate = convertToEntity(studentDto);

        Student savedStudent = studentRepository.saveAndFlush(studentToCreate);
        return savedStudent;
    }

    /**
     * Method delete a student
     *
     * @param id of the student
     */
    @Override
    public void deleteStudent(Long id) {
        Student deleteStudent = studentRepository.getOne(id);
        studentRepository.delete(deleteStudent);
    }

    /**
     * Method edits information of the student
     * It takes DTO, converts it to entity
     * and returns entity
     *
     * @param studentDto
     * @return savedStudent
     */
    @Override
    public Student editStudent(StudentDto studentDto) {
        Student studentToEdit = convertToEntity(studentDto);

        Student savedStudent = studentRepository.saveAndFlush(studentToEdit);
        return savedStudent;
    }

    /**
     * Method receives all students
     *
     * @return [Student]
     */
    @Override
    public Page<Student> getAll(Pageable pageable) {
        return studentRepository.findAll(pageable);
    }

    /**
     * Method receives a student by id
     *
     * @param id of the Student
     * @return student
     */
    @Override
    public Student getById(Long id) {
        Student student = studentRepository.getOne(id);
        return student;
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

//    @Override
//    public StudentDto covertToDto(Student student) {
//        StudentDto studentDto = modelMapper.map(student, StudentDto.class);
//        studentDto.setFirstName(student.getFirstName());
//        studentDto.setLastName(student.getLastName());
//        studentDto.setCourse(student.getCourse());
//        studentDto.setGroupId(student.getGroupId());
//        return studentDto;
//    }
}
