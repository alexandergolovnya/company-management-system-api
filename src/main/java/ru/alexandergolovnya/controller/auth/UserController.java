package ru.alexandergolovnya.controller.auth;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.alexandergolovnya.domain.dto.UserDto;
import ru.alexandergolovnya.domain.request.LoginRequest;
import ru.alexandergolovnya.domain.request.SignUpRequest;
import ru.alexandergolovnya.exception.EmptyRequestDataException;
import ru.alexandergolovnya.exception.NotFoundException;
import ru.alexandergolovnya.exception.NotUniqueCredentialsException;
import ru.alexandergolovnya.service.auth.UserService;

/**
 * REST controller for users sign up and sign in.
 * Provides CRUD operations.
 */

@RestController
@RequestMapping("api")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Method provides login operation for user
     *
     * @param loginRequest
     * @return
     */
    @PostMapping("/login")
    public ResponseEntity<UserDto> login(@RequestBody LoginRequest loginRequest) {
        return ResponseEntity.ok(userService.login(loginRequest));
    }

    /**
     * Method creates new user without provided role.
     * It checks received data at signUpRequest for not null
     * uniqueness of the received email
     *
     * @param signUpRequest - data from the sign up form: email and password, first, middle and last name
     * @return userDto
     * @throws NotUniqueCredentialsException if email of the user already exist
     * @throws EmptyRequestDataException     if email, password received in userForm are null
     */
    @PostMapping("/signup")
    public UserDto createUser(@RequestBody SignUpRequest signUpRequest) throws NotUniqueCredentialsException, EmptyRequestDataException {
        return userService.createUser(signUpRequest);
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
    public UserDto getUser(@PathVariable int id) throws NotFoundException {
        return userService.getById(id);
    }

    /**
     * Method sets deleted state for user
     *
     * @param id of the user
     * @throws NotFoundException if user doesn't exist
     */
    @DeleteMapping("/users/temporary-delete/{id}")
    public void setDeletedStateForUser(@PathVariable int id) throws NotFoundException {
        userService.setDeletedState(id);
    }

    /**
     * Method deletes user from database
     *
     * @param id of the user
     * @throws NotFoundException if user doesn't exist
     */
    @DeleteMapping("/users/{id}")
    public void deleteUserFromDatabase(@PathVariable int id) throws NotFoundException {
        userService.deleteUserFromDatabase(id);
    }


    /**
     * Method edits email, first, middle and last name, student group and department of the user
     *
     * @param id of the user
     * @param userDto - received data: email, first, middle and last name,
     *                student group and department of the user
     * @return userDto
     * @throws NotFoundException if user doesn't exist
     */
    @PutMapping("/users/{id}")
    public UserDto editUser(@RequestBody UserDto userDto, @PathVariable int id) throws NotFoundException {
        return userService.editUser(id, userDto);
    }
}
