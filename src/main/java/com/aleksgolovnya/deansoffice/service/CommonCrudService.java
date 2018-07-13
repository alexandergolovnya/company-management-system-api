package com.aleksgolovnya.deansoffice.service;

/**
 * @param <E> entity class
 * @param <T> dto class
 */
public interface CommonCrudService<E, T> {

    /**
     * Converts dto to entity
     * @param dto
     * @return
     */
    E convertToEntity(T dto);

    /**
     * @param entity
     * @return
     */
    T covertToDto(E entity);
}
