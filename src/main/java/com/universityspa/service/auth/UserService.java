package com.universityspa.service.auth;

import com.universityspa.dto.auth.UserDto;
import com.universityspa.exception.EmptyRequestDataException;
import com.universityspa.exception.NotFoundException;
import com.universityspa.exception.NotUniqueCredentialsException;
import com.universityspa.forms.UserForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {

    UserDto createStudentUser(UserForm userForm) throws NotUniqueCredentialsException, EmptyRequestDataException;
    UserDto createTeacherUser(UserForm userForm) throws NotUniqueCredentialsException, EmptyRequestDataException;
    UserDto createAdminUser(UserForm userForm) throws NotUniqueCredentialsException, EmptyRequestDataException;
    UserDto editUser(Long id, UserForm userForm) throws NotFoundException;
    void deleteUserFromDatabase(Long id) throws NotFoundException;
    void setDeletedState(Long id) throws NotFoundException;
    Page<UserDto> getAll(Pageable pageable);
    UserDto getById(Long id) throws NotFoundException;

}
