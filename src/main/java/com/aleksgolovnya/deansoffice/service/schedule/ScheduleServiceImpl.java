package com.aleksgolovnya.deansoffice.service.schedule;

import com.aleksgolovnya.deansoffice.dto.ScheduleDto;
import com.aleksgolovnya.deansoffice.entity.Schedule;
import com.aleksgolovnya.deansoffice.repository.ScheduleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    private ScheduleRepository scheduleRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Schedule addSchedule(ScheduleDto scheduleDto) {
        Schedule scheduleToCreate = new Schedule();
        scheduleToCreate.setStudentsGroupId(scheduleDto.getStudentsGroupId());
        scheduleToCreate.setSubjectId(scheduleDto.getSubjectId());
        scheduleToCreate.setTeacherId(scheduleDto.getTeacherId());
        Schedule savedSchedule = scheduleRepository.saveAndFlush(scheduleToCreate);
        return savedSchedule;
    }

    @Override
    public void deleteSchedule(Long id) {
        Schedule deleteSchedule = scheduleRepository.getOne(id);
        scheduleRepository.delete(deleteSchedule);
    }

    @Override
    public Schedule editSchedule(ScheduleDto scheduleDto) {
        Schedule schedule = convertToEntity(scheduleDto);
        Schedule savedShedule = scheduleRepository.saveAndFlush(schedule);
        return savedShedule;
    }

    @Override
    public List<Schedule> getAll() {
        return scheduleRepository.findAll();
    }

    @Override
    public Schedule getById(Long id) {
        Schedule schedule = scheduleRepository.getOne(id);
        return schedule;
    }

    @Override
    public Schedule convertToEntity(ScheduleDto scheduleDto) {
        Schedule schedule = modelMapper.map(scheduleDto, Schedule.class);
        schedule.setStudentsGroupId(scheduleDto.getStudentsGroupId());
        schedule.setSubjectId(scheduleDto.getSubjectId());
        schedule.setTeacherId(scheduleDto.getTeacherId());
        return schedule;
    }

    @Override
    public Long getTeacherWorkLoad(Long id) {
//        .orElse(Optional.empty())
        Long teacherWorkLoad = scheduleRepository.getTeacherWorkLoad(id);
        return teacherWorkLoad;
    }

    @Override
    public List<Schedule> getTeacherLessons(Long id) {
        List<Schedule> lessons = scheduleRepository.getTeacherLessons(id);
        return lessons;
    }
}
