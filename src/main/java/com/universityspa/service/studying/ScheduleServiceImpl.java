package com.universityspa.service.studying;

import com.universityspa.dto.ScheduleDto;
import com.universityspa.entity.Schedule;
import com.universityspa.exception.NotFoundException;
import com.universityspa.repository.ScheduleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.universityspa.dto.ScheduleDto.convertFromEntityToDTO;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    private ScheduleRepository scheduleRepository;
    @Autowired
    private ModelMapper modelMapper;

    /**
     * Method creates new record of schedule
     * It takes DTO, converts it to entity
     * save entity to the database, converts entity to dto
     * and return dto-object
     *
     * @param scheduleDto
     * @return ScheduleDto
     */
    @Override
    public ScheduleDto addSchedule(ScheduleDto scheduleDto) {
        Schedule scheduleToCreate = convertToEntity(scheduleDto);
        Schedule savedSchedule = scheduleRepository.saveAndFlush(scheduleToCreate);
        return convertFromEntityToDTO(savedSchedule);
    }

    /**
     * Method deletes record of schedule
     *
     * @param id of the schedule
     * @throws NotFoundException if schedule doesn't exist
     */
    @Override
    public void deleteSchedule(Long id) throws NotFoundException {
        Schedule deleteSchedule = scheduleRepository.getOne(id);
        if (deleteSchedule != null) {
            scheduleRepository.delete(deleteSchedule);
        } else {
            throw new NotFoundException("Unable to delete, subject with such id doesn't exist");
        }
    }

    /**
     * Method edits information of the schedule
     * It takes DTO, converts it to entity
     * save entity to the database, converts entity to dto
     * and return dto-object
     *
     * @param id of the schedule
     * @param scheduleDto
     * @return ScheduleDto
     * @throws NotFoundException if schedule doesn't exist
     */
    @Override
    public ScheduleDto editSchedule(Long id, ScheduleDto scheduleDto) throws NotFoundException {
        Schedule scheduleToEdit = scheduleRepository.getOne(id);

        if (scheduleToEdit != null) {
            scheduleToEdit = convertToEntity(scheduleDto);
            Schedule savedSchedule = scheduleRepository.saveAndFlush(scheduleToEdit);
            return convertFromEntityToDTO(savedSchedule);
        } else {
            throw new NotFoundException("Unable to edit, subject with such id doesn't exist");
        }
    }

    /**
     * Method returns all record of schedule with pagination
     *
     * @param pageable
     * @return Page<ScheduleDto>
     */
    @Override
    public Page<ScheduleDto> getAll(Pageable pageable) {
        Page<Schedule> schedulePage = scheduleRepository.findAll(pageable);
        int totalElements = (int) schedulePage.getTotalElements();
        List<ScheduleDto> scheduleDtoList = schedulePage
                .getContent()
                .stream()
                .map(schedule -> convertFromEntityToDTO(schedule))
                .collect(Collectors.toList());

        Page<ScheduleDto> scheduleDtoPage = new PageImpl<>(scheduleDtoList, pageable, totalElements);
        return scheduleDtoPage;
    }

    /**
     * Method returns schedule by id
     *
     * @param id of the schedule
     * @return ScheduleDto
     * @throws NotFoundException if schedule doesn't exist
     */
    @Override
    public ScheduleDto getById(Long id) throws NotFoundException {
        Schedule schedule = scheduleRepository.getOne(id);
        if (schedule != null) {
            return convertFromEntityToDTO(schedule);
        } else {
            throw new NotFoundException("Subject not found");
        }
    }

    /**
     * Method returns the number of teacher lessons
     * @param id of the teacher
     * @return Long
     */
    @Override
    public Long getTeacherWorkLoad(Long id) {
        Long teacherWorkLoad = scheduleRepository.getTeacherWorkLoad(id);
        return teacherWorkLoad;
    }

    /**
     * Method returns all reoords from schedule for teacher
     * @param id of the teacher
     * @param pageable
     * @return Page<ScheduleDto> - teacher lessons
     */
    @Override
    public Page<ScheduleDto> getTeacherLessons(Long id, Pageable pageable) {
        Page<Schedule> schedulePage = scheduleRepository.getTeacherLessons(id, pageable);
        int totalElements = (int) schedulePage.getTotalElements();
        List<ScheduleDto> scheduleDtoList = schedulePage
                .getContent()
                .stream()
                .map(schedule -> convertFromEntityToDTO(schedule))
                .collect(Collectors.toList());

        Page<ScheduleDto> scheduleDtoPage = new PageImpl<>(scheduleDtoList, pageable, totalElements);
        return scheduleDtoPage;
    }

    /**
     * Method of converting DTO into the entity
     * Uses ModelMapper library
     *
     * @param scheduleDto
     * @return schedule
     */
    @Override
    public Schedule convertToEntity(ScheduleDto scheduleDto) {
        Schedule schedule = modelMapper.map(scheduleDto, Schedule.class);
        schedule.setStudentsGroupId(scheduleDto.getStudentsGroupId());
        schedule.setSubjectId(scheduleDto.getSubjectId());
        schedule.setTeacherId(scheduleDto.getTeacherId());
        schedule.setClassNumber(scheduleDto.getClassNumber());
        schedule.setDate(scheduleDto.getDate());
        return schedule;
    }

    /**
     * Method of converting entity into the DTO
     * Uses ModelMapper library
     *
     * @param schedule
     * @return scheduleDto
     */
    @Override
    public ScheduleDto convertToDto(Schedule schedule) {
        ScheduleDto scheduleDto = modelMapper.map(schedule, ScheduleDto.class);
        scheduleDto.setId(schedule.getId());
        scheduleDto.setClassNumber(schedule.getClassNumber());
        scheduleDto.setDate(schedule.getDate());
        scheduleDto.setStudentsGroupId(schedule.getId());
        scheduleDto.setSubjectId(schedule.getSubjectId());
        scheduleDto.setTeacherId(schedule.getTeacherId());
        return scheduleDto;
    }
}
