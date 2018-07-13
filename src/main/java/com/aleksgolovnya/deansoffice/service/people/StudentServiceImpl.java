package com.aleksgolovnya.deansoffice.service.people;

import com.aleksgolovnya.deansoffice.dto.StudentDto;
import com.aleksgolovnya.deansoffice.entity.Student;
import com.aleksgolovnya.deansoffice.repository.StudentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Student addStudent(StudentDto studentDto) {
        Student studentToCreate = convertToEntity(studentDto);

        Student savedStudent = studentRepository.saveAndFlush(studentToCreate);
        return savedStudent;
    }

    @Override
    public void deleteStudent(Long id) {
        Student deleteStudent = studentRepository.getOne(id);
        studentRepository.delete(deleteStudent);
    }

    @Override
    public Student editStudent(StudentDto studentDto) {
        Student studentToEdit = convertToEntity(studentDto);

        Student savedStudent = studentRepository.saveAndFlush(studentToEdit);
        return savedStudent;
    }

    @Override
    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student getById(Long id) {
        Student student = studentRepository.getOne(id);
        return student;
    }

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
