package com.aleksgolovnya.deansoffice.service.university;

import com.aleksgolovnya.deansoffice.dto.ScheduleDto;
import com.aleksgolovnya.deansoffice.dto.SpecialtyDto;
import com.aleksgolovnya.deansoffice.entity.Specialty;
import com.aleksgolovnya.deansoffice.repository.SpecialtyRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecialtyServiceImpl implements SpecialtyService {

    @Autowired
    private SpecialtyRepository specialtyRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Specialty addSpecialty(SpecialtyDto specialtyDto) {
        Specialty specialtyToCreate = new Specialty();

        specialtyToCreate.setName(specialtyDto.getName());
        specialtyToCreate.setDescription(specialtyDto.getDescription());
        specialtyToCreate.setDepartmentId(specialtyDto.getDepartmentId());

        Specialty savedSpecialty = specialtyRepository.saveAndFlush(specialtyToCreate);
        return savedSpecialty;
    }

    @Override
    public void deleteSpecialty(Long id) {
        Specialty deleteSpecialty = specialtyRepository.getOne(id);
        specialtyRepository.delete(deleteSpecialty);
    }

    @Override
    public Specialty editSpecialty(SpecialtyDto specialtyDto) {
        Specialty specialty = convertToEntity(specialtyDto);
        Specialty savedSpecialty = specialtyRepository.saveAndFlush(specialty);
        return savedSpecialty;
    }

    @Override
    public List<Specialty> getAll() {
        return specialtyRepository.findAll();
    }

    @Override
    public Specialty getById(Long id) {
        Specialty specialty = specialtyRepository.getOne(id);
        return specialty;
    }

    @Override
    public Specialty convertToEntity(SpecialtyDto specialtyDto) {
        Specialty specialty = modelMapper.map(specialtyDto, Specialty.class);
        specialty.setName(specialtyDto.getName());
        specialty.setDescription(specialtyDto.getDescription());
        specialty.setDepartmentId(specialtyDto.getDepartmentId());
        return specialty;
    }
}
