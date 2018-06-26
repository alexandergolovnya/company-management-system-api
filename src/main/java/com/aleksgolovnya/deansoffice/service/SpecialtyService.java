package com.aleksgolovnya.deansoffice.service;

import com.aleksgolovnya.deansoffice.entity.Schedule;
import com.aleksgolovnya.deansoffice.entity.Specialty;

import java.util.List;

public interface SpecialtyService {
    Specialty addSpecialty(Specialty specialty);
    void deleteSpecialty(int id);
    Specialty editSpecialty(Specialty specialty);
    List<Specialty> getAll();
}
