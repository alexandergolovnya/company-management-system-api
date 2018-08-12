package com.universityspa.service.auth;

import com.universityspa.dto.auth.UserDto;
import com.universityspa.exception.EmptyRequestDataException;
import com.universityspa.exception.NotFoundException;
import com.universityspa.exception.NotUniqueCredentialsException;
import com.universityspa.forms.UserForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;

public interface UserService {

    @PreAuthorize("hasAuthority('ADMIN')")
    UserDto createStudentUser(UserForm userForm) throws NotUniqueCredentialsException, EmptyRequestDataException;

    @PreAuthorize("hasAuthority('ADMIN')")
    UserDto createTeacherUser(UserForm userForm) throws NotUniqueCredentialsException, EmptyRequestDataException;

    @PreAuthorize("hasAuthority('ADMIN')")
    UserDto createAdminUser(UserForm userForm) throws NotUniqueCredentialsException, EmptyRequestDataException;

    @PreAuthorize("hasAuthority('ADMIN')")
    UserDto editUser(Long id, UserForm userForm) throws NotFoundException;

    @PreAuthorize("hasAuthority('ADMIN')")
    void deleteUserFromDatabase(Long id) throws NotFoundException;

    @PreAuthorize("hasAuthority('ADMIN')")
    void setDeletedState(Long id) throws NotFoundException;

    @PreAuthorize("hasAuthority('ADMIN')")
    Page<UserDto> getAll(Pageable pageable);

    @PreAuthorize("hasAnyAuthority('ADMIN', 'TEACHER')")
    UserDto getById(Long id) throws NotFoundException;

}
