package ru.alexandergolovnya.service.company;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import ru.alexandergolovnya.domain.dto.DepartmentDto;
import ru.alexandergolovnya.exception.NotFoundException;

/**
 * @author: Alexander Golovnya <mail@alexandergolovnya.ru>
 * @created: 2019/09/04
 */
public interface DepartmentService {

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_DIRECTOR')")
    DepartmentDto addDepartment(DepartmentDto department);

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_DIRECTOR')")
    void deleteDepartment(int id) throws NotFoundException;

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_DIRECTOR')")
    DepartmentDto editDepartment(int id, DepartmentDto department) throws NotFoundException;

    Page<DepartmentDto> getAll(Pageable pageable);

    DepartmentDto getById(int id) throws NotFoundException;
}


