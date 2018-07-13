package com.aleksgolovnya.deansoffice;

import com.aleksgolovnya.deansoffice.dto.StudentDto;
import com.aleksgolovnya.deansoffice.entity.Student;
import org.junit.Assert;
import org.junit.Test;
import org.modelmapper.ModelMapper;

/**
 * Tests methods of converting DTO into entity
 * and entity into DTO for Student.
 * Uses ModelMapper library for converting.
 */
public class StudentDtoUnitTest {

    private ModelMapper modelMapper = new ModelMapper();

    /**
     * Convert Student DTO into Student entity
     */
    @Test
    public void convertStudentDtoToStudentEntity() {
        StudentDto studentDto = new StudentDto();
        studentDto.setId(new Long(1));
        studentDto.setFirstName("Jonathan");
        studentDto.setLastName("Bing");
        studentDto.setCourse(4);
        studentDto.setGroupId(new Long(1));

        Student student = modelMapper.map(studentDto, Student.class);
        Assert.assertEquals(studentDto.getId(), student.getId());
        Assert.assertEquals(studentDto.getFirstName(), student.getFirstName());
        Assert.assertEquals(studentDto.getLastName(), student.getLastName());
        Assert.assertEquals(studentDto.getCourse(), student.getCourse());
        Assert.assertEquals(studentDto.getGroupId(), student.getGroupId());

        System.out.println("Converting Student DTO into Student entity");
        System.out.println("Student DTO: " + studentDto);
        System.out.println("Student entity: " + student);
    }

    /**
     * Convert Student entity into Student DTO
     */
    @Test
    public void convertStudentEntityToStudentDto() {
        Student student = new Student();
        student.setId(new Long(1));
        student.setFirstName("Jonathan");
        student.setLastName("Bing");
        student.setCourse(4);
        student.setGroupId(new Long(1));

        StudentDto studentDto = modelMapper.map(student, StudentDto.class);
        Assert.assertEquals(student.getId(), studentDto.getId());
        Assert.assertEquals(student.getFirstName(), studentDto.getFirstName());
        Assert.assertEquals(student.getLastName(), studentDto.getLastName());
        Assert.assertEquals(student.getCourse(), studentDto.getCourse());
        Assert.assertEquals(student.getGroupId(), studentDto.getGroupId());

        System.out.println("Convert Student entity into Student DTO");
        System.out.println("Student entity: " + studentDto);
        System.out.println("Student DTO: " + student);
    }
}
