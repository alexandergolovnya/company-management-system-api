package ru.alexandergolovnya.service.auth;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import ru.alexandergolovnya.domain.dto.UserDto;
import ru.alexandergolovnya.domain.request.LoginRequest;
import ru.alexandergolovnya.domain.request.SignUpRequest;
import ru.alexandergolovnya.exception.EmptyRequestDataException;
import ru.alexandergolovnya.exception.NotFoundException;
import ru.alexandergolovnya.exception.NotUniqueCredentialsException;

/**
 * @author: Alexander Golovnya <mail@alexandergolovnya.ru>
 * @created: 2019/09/04
 */
public interface UserService {

    UserDto login(LoginRequest loginRequest);

    UserDto createUser(SignUpRequest signUpRequest) throws NotUniqueCredentialsException, EmptyRequestDataException;

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_DIRECTOR', 'ROLE_HR_MANAGER')")
    UserDto editUser(int id, UserDto userDto) throws NotFoundException;

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_DIRECTOR', 'ROLE_HR_MANAGER')")
    void deleteUserFromDatabase(int id) throws NotFoundException;

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_DIRECTOR', 'ROLE_HR_MANAGER')")
    void setDeletedState(int id) throws NotFoundException;

    Page<UserDto> getAll(Pageable pageable);

    UserDto getById(int id) throws NotFoundException;

    Page<UserDto> getDepartmentEmployees(int id, Pageable pageable);

}
