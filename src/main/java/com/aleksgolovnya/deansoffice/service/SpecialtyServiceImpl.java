package com.aleksgolovnya.deansoffice.service;

import com.aleksgolovnya.deansoffice.entity.Specialty;
import com.aleksgolovnya.deansoffice.repository.SpecialtyRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SpecialtyServiceImpl implements SpecialtyService {

    @Autowired
    private SpecialtyRepository specialtyRepository;

    @Override
    public Specialty addSpecialty(Specialty specialty) {
        Specialty savedSpecialty = specialtyRepository.saveAndFlush(specialty);
        return savedSpecialty;
    }

    @Override
    public void deleteSpecialty(int id) {

    }

    @Override
    public Specialty editSpecialty(Specialty specialty) {
        return specialtyRepository.saveAndFlush(specialty);
    }

    @Override
    public List<Specialty> getAll() {
        return specialtyRepository.findAll();
    }
}
