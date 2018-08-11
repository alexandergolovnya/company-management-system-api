package com.universityspa.service.studying;

import com.universityspa.dto.ScheduleDto;
import com.universityspa.entity.Journal;
import com.universityspa.entity.Schedule;
import com.universityspa.repository.ScheduleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        scheduleToCreate.setClassNumber(scheduleDto.getClassNumber());
        scheduleToCreate.setDate(scheduleDto.getDate());
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
        schedule.setClassNumber(scheduleDto.getClassNumber());
        schedule.setDate(scheduleDto.getDate());
        return schedule;
    }

    @Override
    public Long getTeacherWorkLoad(Long id) {
        Long teacherWorkLoad = scheduleRepository.getTeacherWorkLoad(id);
        return teacherWorkLoad;
    }

    @Override
    public List<Schedule> getTeacherLessons(Long id) {
        List<Schedule> lessons = scheduleRepository.getTeacherLessons(id);
        return lessons;
    }

    /**
     * Method receives all journal records for the record in the schedule (lesson)
     *
     * @param id of the schedule
     * @return [Journal]
     */
    @Override
    public List<Journal> getJournalForScheduleRecord(Long id) {
        List<Journal> journalRecords = scheduleRepository.getJournalForScheduleRecord(id);
        return journalRecords;
    }
}
