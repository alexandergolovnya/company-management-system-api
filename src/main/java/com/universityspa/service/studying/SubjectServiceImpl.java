package com.universityspa.service.studying;

import com.universityspa.dto.SubjectDto;
import com.universityspa.entity.Subject;
import com.universityspa.exception.NotFoundException;
import com.universityspa.repository.SubjectRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private ModelMapper modelMapper;

    /**
     * Method creates new subject
     * It takes DTO, converts it to entity
     * save entity to the database, converts entity to dto
     * and return dto-object
     *
     * @param subjectDto
     * @return subjectDto
     */
    @Override
    public SubjectDto addSubject(SubjectDto subjectDto) {
        Subject subjectToCreate = convertToEntity(subjectDto);
        Subject savedSubject = subjectRepository.saveAndFlush(subjectToCreate);
        return convertToDto(savedSubject);
    }

    /**
     * Method deletes subject
     *
     * @param id of the subject
     * @throws NotFoundException if subject doesn't exist
     */
    @Override
    public void deleteSubject(Long id) throws NotFoundException {
        Subject deleteSubject = subjectRepository.getOne(id);
        if (deleteSubject != null) {
            subjectRepository.delete(deleteSubject);
        } else {
            throw new NotFoundException("Unable to delete, subject with such id doesn't exist");
        }
    }

    /**
     * Method edits information of the subject
     * It takes DTO, converts it to entity
     * save entity to the database, converts entity to dto
     * and return dto-object
     *
     * @param id of the subject
     * @param subjectDto
     * @return editedSubject
     * @throws NotFoundException if subject doesn't exist
     */
    @Override
    public SubjectDto editSubject(Long id, SubjectDto subjectDto) throws NotFoundException {
        Subject subjectToEdit = subjectRepository.getOne(id);

        if (subjectToEdit != null) {
            subjectToEdit = convertToEntity(subjectDto);
            Subject savedSubject = subjectRepository.saveAndFlush(subjectToEdit);
            return convertToDto(savedSubject);
        } else {
            throw new NotFoundException("Unable to edit, subject with such id doesn't exist");
        }
    }

    /**
     * Method returns all subjects with pagination
     *
     * @param pageable
     * @return subjectDtoPage
     */
    @Override
    public Page<SubjectDto> getAll(Pageable pageable) {
        Page<Subject> subjectPage = subjectRepository.findAll(pageable);
        int totalElements = (int) subjectPage.getTotalElements();
        List<SubjectDto> subjectDtoList = subjectPage
                .getContent()
                .stream()
                .map(subject -> convertToDto(subject))
                .collect(Collectors.toList());

        Page<SubjectDto> subjectDtoPage = new PageImpl<>(subjectDtoList, pageable, totalElements);
        return subjectDtoPage;
    }

    /**
     * Method returns subject by id
     *
     * @param id of the subject
     * @return subjectDto
     * @throws NotFoundException if subject doesn't exist
     */
    @Override
    public SubjectDto getById(Long id) throws NotFoundException {
        Subject subject = subjectRepository.getOne(id);
        if (subject != null) {
            return convertToDto(subject);
        } else {
            throw new NotFoundException("Subject not found");
        }

    }

    /**
     * Method of converting DTO into the entity
     * Uses ModelMapper library
     *
     * @param subjectDto
     * @return subject
     */
    @Override
    public Subject convertToEntity(SubjectDto subjectDto) {
        Subject subject = modelMapper.map(subjectDto, Subject.class);
        subject.setId(subjectDto.getId());
        subject.setName(subjectDto.getName());
        subject.setDescription(subjectDto.getDescription());
        return subject;
    }

    /**
     * Method of converting entity into the DTO
     * Uses ModelMapper library
     *
     * @param subject
     * @return subjectDto
     */
    @Override
    public SubjectDto convertToDto(Subject subject) {
        SubjectDto subjectDto = modelMapper.map(subject, SubjectDto.class);
        subjectDto.setId(subject.getId());
        subjectDto.setName(subject.getName());
        subjectDto.setDescription(subject.getDescription());
        return subjectDto;
    }


}
