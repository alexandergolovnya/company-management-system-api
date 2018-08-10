package com.universityspa.controller.auth;

import com.universityspa.dto.auth.UserDto;
import com.universityspa.entity.auth.User;
import com.universityspa.forms.UserForm;
import com.universityspa.service.auth.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.universityspa.dto.auth.UserDto.from;

/**
 * REST controller for users sign up
 */

@RestController
@RequestMapping("api/users")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * Method returns all users
     * @return [User]
     */
    @GetMapping
    public List<UserDto> getUsers() {
        return from(userService.getAll());
    }

    /**
     * Method retirns one user by id
     * @param id of the user
     * @return User
     */
    @GetMapping
    public User getUser(@PathVariable Long id) {
        return userService.getById(id);
    }

    /**
     * Method creates new user
     * @param userForm
     * @return
     */
    @PostMapping
    public ResponseEntity<Object> createUser(@RequestBody UserForm userForm) {
        userService.addUser(userForm);
        return ResponseEntity.ok().build();
    }
}
