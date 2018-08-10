package com.aleksgolovnya.deansoffice.service.auth;

import com.aleksgolovnya.deansoffice.entity.auth.User;
import com.aleksgolovnya.deansoffice.forms.UserForm;

import java.util.List;

public interface UserService {

    void addUser(UserForm userForm);
    List<User> getAll();
    User getById(Long id);
}
