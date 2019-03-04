package com.universityspa.service.auth;

import com.universityspa.dto.auth.AuthLoginResponseDto;
import com.universityspa.dto.auth.UserDto;
import com.universityspa.dto.forms.LoginForm;
import com.universityspa.dto.forms.UserForm;
import com.universityspa.exception.EmptyRequestDataException;
import com.universityspa.exception.NotFoundException;
import com.universityspa.exception.NotUniqueCredentialsException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;

public interface UserService {

    AuthLoginResponseDto login(LoginForm loginForm);

    UserDto createUser(UserForm userForm) throws NotUniqueCredentialsException, EmptyRequestDataException;

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    UserDto editUser(Long id, UserDto userDto) throws NotFoundException;

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    void deleteUserFromDatabase(Long id) throws NotFoundException;

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    void setDeletedState(Long id) throws NotFoundException;

    Page<UserDto> getAll(Pageable pageable);

    UserDto getById(Long id) throws NotFoundException;

    Page<UserDto> getStudentGroupStudents(Long id, Pageable pageable);

    Page<UserDto> getDepartmentTeachers(Long id, Pageable pageable);

}
