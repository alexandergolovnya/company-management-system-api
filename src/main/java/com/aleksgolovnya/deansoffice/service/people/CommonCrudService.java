package com.aleksgolovnya.deansoffice.service.people;

import com.aleksgolovnya.deansoffice.dto.StudentDto;
import com.aleksgolovnya.deansoffice.entity.Student;

import java.util.List;

/**
 *
 * @param <E> entity class
 * @param <T> dto class
 */
public interface CommonCrudService<E, T> {
    /**
     * Converts dto to entity
     * @param studentDto
     * @return
     */
    E convertToEntity(T studentDto);

    T covertToDto(E entity);
}
