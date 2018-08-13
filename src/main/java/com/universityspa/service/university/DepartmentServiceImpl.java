package com.universityspa.service.university;

import com.universityspa.dto.DepartmentDto;
import com.universityspa.entity.Department;
import com.universityspa.exception.NotFoundException;
import com.universityspa.repository.DepartmentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.universityspa.dto.DepartmentDto.convertFromEntityToDTO;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private ModelMapper modelMapper;

    /**
     * Method creates new department
     * It takes DTO, converts it to entity
     * save entity to the database, converts entity to dto
     * and return dto-object
     *
     * @param departmentDto
     * @return DepartmentDto
     */
    @Override
    public DepartmentDto addDepartment(DepartmentDto departmentDto) {
        Department departmentToCreate = convertToEntity(departmentDto);
        Department savedDepartment = departmentRepository.saveAndFlush(departmentToCreate);
        return convertFromEntityToDTO(savedDepartment);
    }

    /**
     * Method deletes department
     *
     * @param id of the department
     * @throws NotFoundException if department doesn't exist
     */
    @Override
    public void deleteDepartment(Long id) throws NotFoundException {
        Department deleteDepartment = departmentRepository.getOne(id);
        if (deleteDepartment != null) {
            departmentRepository.delete(deleteDepartment);
        } else {
            throw new NotFoundException("Unable to delete, department with such id doesn't exist");
        }
    }

    /**
     * Method edits information of the department
     * It takes DTO, converts it to entity
     * save entity to the database, converts entity to dto
     * and return dto-object
     * @param id of the department
     * @param departmentDto
     * @return DepartmentDto
     */
    @Override
    public DepartmentDto editDepartment(Long id, DepartmentDto departmentDto) throws NotFoundException {
        Department departmentToEdit = departmentRepository.getOne(id);
        if (departmentToEdit != null) {
            departmentToEdit = convertToEntity(departmentDto);
            Department savedDepartment = departmentRepository.saveAndFlush(departmentToEdit);
            return convertFromEntityToDTO(savedDepartment);
        } else {
            throw new NotFoundException("Unable to edit, department with such id doesn't exist");
        }
    }

    /**
     * Method returns all departments with pagination
     *
     * @param pageable
     * @return Page<DepartmentDto>
     */
    @Override
    public Page<DepartmentDto> getAll(Pageable pageable) {
        Page<Department> departmentPage = departmentRepository.findAll(pageable);
        int totalElements = (int) departmentPage.getTotalElements();
        List<DepartmentDto> departmentDtoList = departmentPage
                .getContent()
                .stream()
                .map(department -> convertFromEntityToDTO(department))
                .collect(Collectors.toList());

        Page<DepartmentDto> departmentDtoPage = new PageImpl<>(departmentDtoList, pageable, totalElements);
        return departmentDtoPage;
    }

    /**
     * Method returns department by id
     *
     * @param id of the department
     * @return DepartmentDto
     * @throws NotFoundException if department doesn't exist
     */
    @Override
    public DepartmentDto getById(Long id) throws NotFoundException {
        Department department = departmentRepository.getOne(id);
        if (department != null) {
            DepartmentDto departmentDto = convertFromEntityToDTO(department);
            return departmentDto;
        } else {
            throw new NotFoundException("Department not found");
        }
    }

    /**
     * Method returns departments for faculty with pagination
     *
     * @param id of the faculty
     * @return departmentDtoPage
     */
    @Override
    public Page<DepartmentDto> getFacultyDepartments(Long id, Pageable pageable) {
        Page<Department> departmentPage = departmentRepository.getFacultyDepartments(id, pageable);
        int totalElements = (int) departmentPage.getTotalElements();
        List<DepartmentDto> departmentDtoList = departmentPage
                .getContent()
                .stream()
                .map(department -> convertFromEntityToDTO(department))
                .collect(Collectors.toList());

        Page<DepartmentDto> departmentDtoPage = new PageImpl<>(departmentDtoList, pageable, totalElements);
        return departmentDtoPage;
    }

    /**
     * Method of converting DTO into the entity
     * Uses ModelMapper library
     *
     * @param departmentDto
     * @return department
     */
    @Override
    public Department convertToEntity(DepartmentDto departmentDto) {
        Department department = modelMapper.map(departmentDto, Department.class);
        department.setId(departmentDto.getId());
        department.setName(departmentDto.getName());
        department.setDescription(departmentDto.getDescription());
        department.setFacultyId(departmentDto.getFacultyId());
        return department;
    }

    /**
     * Method of converting entity into the DTO
     * Uses ModelMapper library
     *
     * @param department
     * @return departmentDto
     */
    @Override
    public DepartmentDto convertToDto(Department department) {
        DepartmentDto departmentDto = modelMapper.map(department, DepartmentDto.class);
        departmentDto.setId(department.getId());
        departmentDto.setName(department.getName());
        departmentDto.setDescription(department.getDescription());
        departmentDto.setFacultyId(department.getFacultyId());
        return departmentDto;
    }
}
