package com.universityspa.service;

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
    T convertToDto(E entity);
}
