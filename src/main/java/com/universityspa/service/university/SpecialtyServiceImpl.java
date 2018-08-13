package com.universityspa.service.university;

import com.universityspa.dto.SpecialtyDto;
import com.universityspa.entity.Specialty;
import com.universityspa.exception.NotFoundException;
import com.universityspa.repository.SpecialtyRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.universityspa.dto.SpecialtyDto.convertFromEntityToDTO;

@Service
public class SpecialtyServiceImpl implements SpecialtyService {

    @Autowired
    private SpecialtyRepository specialtyRepository;

    @Autowired
    private ModelMapper modelMapper;

    /**
     * Method creates new specialty
     * It takes DTO, converts it to entity
     * save entity to the database, converts entity to dto
     * and return dto-object
     *
     * @param specialtyDto
     * @return SpecialtyDto
     */
    @Override
    public SpecialtyDto addSpecialty(SpecialtyDto specialtyDto) {
        Specialty specialtyToCreate = convertToEntity(specialtyDto);
        Specialty savedSpecialty = specialtyRepository.saveAndFlush(specialtyToCreate);
        return convertFromEntityToDTO(savedSpecialty);
    }

    /**
     * Method deletes specialty by id
     *
     * @param id of the specialty
     * @throws NotFoundException if specialty doesn't exist
     */
    @Override
    public void deleteSpecialty(Long id) throws NotFoundException {
        Specialty deleteSpecialty = specialtyRepository.getOne(id);
        if (deleteSpecialty != null) {
            specialtyRepository.delete(deleteSpecialty);
        } else {
            throw new NotFoundException("Unable to delete, faculty with such id doesn't exist");
        }
    }

    /**
     * Method edits information of the specialty
     * It takes DTO, converts it to entity
     * save entity to the database, converts entity to dto
     * and return dto-object
     *
     * @param id of the specialty
     * @param specialtyDto
     * @return SpecialtyDto
     * @throws NotFoundException if specialty doesn't exist
     */
    @Override
    public SpecialtyDto editSpecialty(Long id, SpecialtyDto specialtyDto) throws NotFoundException {
        Specialty specialtyToEdit = specialtyRepository.getOne(id);
        if (specialtyToEdit != null) {
            specialtyToEdit = convertToEntity(specialtyDto);
            Specialty savedSpecialty = specialtyRepository.saveAndFlush(specialtyToEdit);
            return convertFromEntityToDTO(savedSpecialty);
        } else {
            throw new NotFoundException("Unable to edit, faculty with such id doesn't exist");
        }
    }

    /**
     * Method returns all specialties with pagination
     *
     * @param pageable
     * @return Page<SpecialtyDto>
     */
    @Override
    public Page<SpecialtyDto> getAll(Pageable pageable) {
        Page<Specialty> specialtyPage = specialtyRepository.findAll(pageable);
        int totalElements = (int) specialtyPage.getTotalElements();
        List<SpecialtyDto> specialtyDtoList = specialtyPage
                .getContent()
                .stream()
                .map(specialty -> convertFromEntityToDTO(specialty))
                .collect(Collectors.toList());

        Page<SpecialtyDto> specialtyDtoPage = new PageImpl<>(specialtyDtoList, pageable, totalElements);
        return specialtyDtoPage;
    }

    /**
     * Method returns specialty by id
     * @param id
     * @return SpecialtyDto
     * @throws NotFoundException if specialty doesn't exist
     */
    @Override
    public SpecialtyDto getById(Long id) throws NotFoundException {
        Specialty specialty = specialtyRepository.getOne(id);
        if (specialty != null) {
            SpecialtyDto specialtyDto = convertFromEntityToDTO(specialty);
            return specialtyDto;
        } else {
            throw new NotFoundException("Faculty not found");
        }
    }

    /**
     * Method receives all specialties for department
     *
     * @param id of the Department
     * @return List<SpecialtyDto>
     */
    @Override
    public Page<SpecialtyDto> getDepartmentSpecialties(Long id, Pageable pageable) {
        Page<Specialty> specialtyPage = specialtyRepository.getDepartmentSpecialties(id, pageable);
        int totalElements = (int) specialtyPage.getTotalElements();
        List<SpecialtyDto> specialtyDtoList = specialtyPage
                .getContent()
                .stream()
                .map(specialty -> convertFromEntityToDTO(specialty))
                .collect(Collectors.toList());

        Page<SpecialtyDto> specialtyDtoPage = new PageImpl<>(specialtyDtoList, pageable, totalElements);
        return specialtyDtoPage;
    }

    /**
     * Method of converting DTO into the entity
     * Uses ModelMapper library
     *
     * @param specialtyDto
     * @return specialty
     */
    @Override
    public Specialty convertToEntity(SpecialtyDto specialtyDto) {
        Specialty specialty = modelMapper.map(specialtyDto, Specialty.class);
        specialty.setName(specialtyDto.getName());
        specialty.setDescription(specialtyDto.getDescription());
        specialty.setDepartmentId(specialtyDto.getDepartmentId());
        return specialty;
    }

    /**
     * Method of converting entity into the DTO
     * Uses ModelMapper library
     *
     * @param specialty
     * @return specialtyDto
     */
    @Override
    public SpecialtyDto convertToDto(Specialty specialty) {
        SpecialtyDto specialtyDto = modelMapper.map(specialty, SpecialtyDto.class);
        specialtyDto.setId(specialty.getId());
        specialtyDto.setName(specialty.getName());
        specialtyDto.setDepartmentId(specialty.getDepartmentId());
        return specialtyDto;
    }
}
