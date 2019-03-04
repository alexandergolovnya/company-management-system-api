package com.universityspa.controller.auth;

import com.universityspa.dto.auth.AuthLoginResponseDto;
import com.universityspa.dto.auth.UserDto;
import com.universityspa.dto.forms.LoginForm;
import com.universityspa.dto.forms.UserForm;
import com.universityspa.exception.EmptyRequestDataException;
import com.universityspa.exception.NotFoundException;
import com.universityspa.exception.NotUniqueCredentialsException;
import com.universityspa.service.auth.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * REST controller for users sign up
 * Provides CRUD operations.
 */

@RestController
@RequestMapping("api")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * Method provides login operation for user
     *
     * @param loginForm
     * @return
     */
    @PostMapping("/login")
    public ResponseEntity<AuthLoginResponseDto> login(@RequestBody LoginForm loginForm) {
        return ResponseEntity.ok(userService.login(loginForm));
    }

    /**
     * Method creates new user without admin rules.
     * It checks received data at userForm for not null
     * uniqueness of the received email
     *
     * @param userForm - data from the sign up form: email and password, first, middle and last name
     * @return userDto
     * @throws NotUniqueCredentialsException if email of the user already exist
     * @throws EmptyRequestDataException     if email, password received in userForm are null
     */
    @PostMapping("/signup")
    public UserDto createUser(@RequestBody UserForm userForm) throws NotUniqueCredentialsException, EmptyRequestDataException {
        return userService.createUser(userForm);
    }

    /**
     * Method returns all users with pagination
     * @return Page<UserDto>
     */
    @GetMapping("/users")
    public Page<UserDto> getUsers(Pageable pageable) {
        return userService.getAll(pageable);
    }

    /**
     * Method returns one user by id
     * @param id of the user
     * @return UserDto
     * @throws NotFoundException if user doesn't exist
     */
    @GetMapping("/users/{id}")
    public UserDto getUser(@PathVariable Long id) throws NotFoundException {
        return userService.getById(id);
    }

    /**
     * Method sets deleted state for user
     *
     * @param id of the user
     * @throws NotFoundException if user doesn't exist
     */
    @DeleteMapping("/users/temporary-delete/{id}")
    public void setDeletedStateForUser(@PathVariable Long id) throws NotFoundException {
        userService.setDeletedState(id);
    }

    /**
     * Method deletes user from database
     *
     * @param id of the user
     * @throws NotFoundException if user doesn't exist
     */
    @DeleteMapping("/users/{id}")
    public void deleteUserFromDatabase(@PathVariable Long id) throws NotFoundException {
        userService.deleteUserFromDatabase(id);
    }


    /**
     * Method edits email, first, middle and last name, student group and department of the user
     *
     * @param id of the user
     * @param userDto - received data: email, first, middle and last name,
     *                student group and department of the user
     * @return userDto
     * @throws NotFoundException
     */
    @PutMapping("/users/{id}")
    public UserDto editUser(@RequestBody UserDto userDto, @PathVariable Long id) throws NotFoundException {
        return userService.editUser(id, userDto);
    }
}
