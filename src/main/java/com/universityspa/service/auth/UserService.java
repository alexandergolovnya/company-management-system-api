package com.universityspa.service.auth;

import com.universityspa.entity.auth.User;
import com.universityspa.forms.UserForm;

import java.util.List;

public interface UserService {

    void addUser(UserForm userForm);
    List<User> getAll();
    User getById(Long id);
}
