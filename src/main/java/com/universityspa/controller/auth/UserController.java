package com.universityspa.controller.auth;

import com.universityspa.dto.auth.UserDto;
import com.universityspa.exception.EmptyRequestDataException;
import com.universityspa.exception.NotFoundException;
import com.universityspa.exception.NotUniqueCredentialsException;
import com.universityspa.dto.forms.UserForm;
import com.universityspa.service.auth.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

/**
 * REST controller for users sign up
 * Provides CRUD operations.
 */

@RestController
@RequestMapping("api/users")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * Method returns all users with pagination
     * @return Page<UserDto>
     */
    @GetMapping
    public Page<UserDto> getUsers(Pageable pageable) {
        return userService.getAll(pageable);
    }

    /**
     * Method returns one user by id
     * @param id of the user
     * @return UserDto
     * @throws NotFoundException if user doesn't exist
     */
    @GetMapping("/{id}")
    public UserDto getUser(@PathVariable Long id) throws NotFoundException {
        return userService.getById(id);
    }

    /**
     * Method creates new user with Student role
     *
     * @param userForm
     * @return UserDto
     * @throws NotUniqueCredentialsException if email of the user already exist or if teacherId is specified
     * @throws EmptyRequestDataException if email, password or studentId received in userForm are null
     */
    @PostMapping("/student")
    public UserDto createStudentUser(@RequestBody UserForm userForm) throws NotUniqueCredentialsException, EmptyRequestDataException {
        return userService.createStudentUser(userForm);
    }

    /**
     * Method creates new user with Teacher role
     *
     * @param userForm
     * @return UserDto
     * @throws NotUniqueCredentialsException if email of the user already exist or if teacherId is specified
     * @throws EmptyRequestDataException if email, password or studentId received in userForm are null
     */
    @PostMapping("/teacher")
    public UserDto createTeacherUser(@RequestBody UserForm userForm) throws NotUniqueCredentialsException, EmptyRequestDataException {
        return userService.createTeacherUser(userForm);
    }

    /**
     * (!) Method for developers version, should be switch of in production
     * Method creates new user with Admin role
     *
     * @param userForm
     * @return UserDto
     * @throws NotUniqueCredentialsException if email of the user already exist
     * @throws EmptyRequestDataException if email or password received in userForm are null
     */
    @PostMapping("/admin")
    public UserDto createAdminUser(@RequestBody UserForm userForm) throws NotUniqueCredentialsException, EmptyRequestDataException {
        return userService.createAdminUser(userForm);
    }

    /**
     * Method sets deleted state for user
     *
     * @param id of the user
     * @throws NotFoundException if user doesn't exist
     */
    @DeleteMapping("/{id}")
    public void setDeletedStateForUser(@PathVariable Long id) throws NotFoundException {
        userService.setDeletedState(id);
    }

    /**
     * Method deletes user from database
     *
     * @param id of the user
     * @throws NotFoundException if user doesn't exist
     */
    @DeleteMapping("/from-database/{id}")
    public void deleteUserFromDatabase(@PathVariable Long id) throws NotFoundException {
        userService.deleteUserFromDatabase(id);
    }


    /**
     * Method edits information of the user
     *
     * @param userForm - received data: email and password
     * @param id of the user
     * @return userDto
     * @throws NotFoundException if user doesn't exist
     */
    @PutMapping("/{id}")
    public UserDto editUser(@RequestBody UserForm userForm, @PathVariable Long id) throws NotFoundException {
        return userService.editUser(id, userForm);
    }
}
