package com.aleksgolovnya.deansoffice.service.university;

import com.aleksgolovnya.deansoffice.dto.DepartmentDto;
import com.aleksgolovnya.deansoffice.entity.Department;
import com.aleksgolovnya.deansoffice.entity.Specialty;
import com.aleksgolovnya.deansoffice.entity.Teacher;
import com.aleksgolovnya.deansoffice.repository.DepartmentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Department addDepartment(DepartmentDto departmentDto) {
        Department departmentToCreate = new Department();

        departmentToCreate.setName(departmentDto.getName());
        departmentToCreate.setDescription(departmentDto.getDescription());
        departmentToCreate.setFacultyId(departmentDto.getFacultyId());

        Department savedDepartment = departmentRepository.saveAndFlush(departmentToCreate);
        return savedDepartment;
    }

    @Override
    public void deleteDepartment(Long id) {
        Department deleteDepartment = departmentRepository.getOne(id);
        departmentRepository.delete(deleteDepartment);
    }

    @Override
    public Department editDepartment(DepartmentDto departmentDto) {
        Department department = convertToEntity(departmentDto);
        Department savedDepartment =  departmentRepository.saveAndFlush(department);
        return savedDepartment;
    }

    @Override
    public List<Department> getAll() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getById(Long id) {
        Department department = departmentRepository.getOne(id);
        return department;
    }

    @Override
    public Department convertToEntity(DepartmentDto departmentDto) {
        Department department = modelMapper.map(departmentDto, Department.class);
        department.setName(departmentDto.getName());
        department.setDescription(departmentDto.getDescription());
        department.setFacultyId(departmentDto.getFacultyId());
        return department;
    }

    /**
     * Method receives all specialties of this department
     * @param id of the Department
     * @return departmentSpecialties
     */
    @Override
    public List<Specialty> getDepartmentSpecialties(Long id) {
        List<Specialty> departmentSpecialties = departmentRepository.getDepartmentSpecialties(id);
        return departmentSpecialties;
    }

    /**
     * Method receives all teachers of this department
     *
     * @param id of the department
     * @return [Teacher]
     */
    @Override
    public List<Teacher> getDepartmentTeachers(Long id) {
        List<Teacher> teachers = departmentRepository.getDepartmentTeachers(id);
        return teachers;
    }
}
