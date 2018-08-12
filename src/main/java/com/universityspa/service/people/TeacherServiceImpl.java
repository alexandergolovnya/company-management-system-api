package com.universityspa.service.people;

import com.universityspa.dto.TeacherDto;
import com.universityspa.entity.Schedule;
import com.universityspa.entity.Teacher;
import com.universityspa.repository.TeacherRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
     * and returns entity
     *
     * @param teacherDto
     * @return savedTeacher
     */
    @Override
    public Teacher addTeacher(TeacherDto teacherDto) {
        Teacher teacherToCreate = new Teacher();

        teacherToCreate.setFirstName(teacherDto.getFirstName());
        teacherToCreate.setLastName(teacherDto.getLastName());
        teacherToCreate.setPosition(teacherDto.getPosition());
        teacherToCreate.setDepartmentId(teacherDto.getDepartmentId());

        Teacher savedTeacher = teacherRepository.saveAndFlush(teacherToCreate);
        return savedTeacher;
    }

    @Override
    public void deleteTeacher(Long id) {
        Teacher deleteTeacher = teacherRepository.getOne(id);
        teacherRepository.delete(deleteTeacher);
    }

    @Override
    public Teacher editTeacher(TeacherDto teacherDto) {
        Teacher teacher = convertToEntity(teacherDto);

        Teacher savedTeacher = teacherRepository.saveAndFlush(teacher);
        return savedTeacher;
    }

    @Override
    public List<Teacher> getAll() {
        return teacherRepository.findAll();
    }

    @Override
    public Teacher getById(Long id) {
        Teacher teacher = teacherRepository.getOne(id);
        return teacher;
    }

    /**
     * Method receives all records convertFromEntityToDTO the schedule for this teacher
     *
     * @param id of the teacher
     * @return [Schedule]
     */
    @Override
    public List<Schedule> getTeachersSchedule(Long id) {
        List<Schedule> scheduleList = teacherRepository.getTeachersSchedule(id);
        return scheduleList;
    }

    @Override
    public Teacher convertToEntity(TeacherDto teacherDto) {
        Teacher teacher = modelMapper.map(teacherDto, Teacher.class);
        teacher.setFirstName(teacherDto.getFirstName());
        teacher.setLastName(teacherDto.getLastName());
        teacher.setPosition(teacherDto.getPosition());
        teacher.setDepartmentId(teacherDto.getDepartmentId());
        return teacher;
    }


}