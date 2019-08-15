package ru.alexandergolovnya.service.company;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.alexandergolovnya.domain.dto.DepartmentDto;
import ru.alexandergolovnya.domain.entity.company.Department;
import ru.alexandergolovnya.domain.repository.DepartmentRepository;
import ru.alexandergolovnya.exception.NotFoundException;

import java.util.List;
import java.util.stream.Collectors;

import static ru.alexandergolovnya.utils.ObjectMapperUtils.map;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

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
        Department departmentToCreate = map(departmentDto, Department.class);
        Department savedDepartment = departmentRepository.save(departmentToCreate);
        return map(savedDepartment, DepartmentDto.class);
    }

    /**
     * Method deletes department
     *
     * @param id of the department
     * @throws NotFoundException if department doesn't exist
     */
    @Override
    public void deleteDepartment(int id) throws NotFoundException {
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
    public DepartmentDto editDepartment(int id, DepartmentDto departmentDto) throws NotFoundException {
        Department departmentToEdit = departmentRepository.getOne(id);
        if (departmentToEdit != null) {
            departmentToEdit = map(departmentDto, Department.class);
            Department savedDepartment = departmentRepository.saveAndFlush(departmentToEdit);
            return map(savedDepartment, DepartmentDto.class);
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
                .map(department ->  map(department, DepartmentDto.class))
                .collect(Collectors.toList());

        return new PageImpl<>(departmentDtoList, pageable, totalElements);
    }

    /**
     * Method returns department by id
     *
     * @param id of the department
     * @return DepartmentDto
     * @throws NotFoundException if department doesn't exist
     */
    @Override
    public DepartmentDto getById(int id) throws NotFoundException {
        Department department = departmentRepository.getOne(id);
        if (department != null) {
            return map(department, DepartmentDto.class);
        } else {
            throw new NotFoundException("Department not found");
        }
    }
}
