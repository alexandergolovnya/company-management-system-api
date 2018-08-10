package com.aleksgolovnya.deansoffice.service.auth;

import com.aleksgolovnya.deansoffice.entity.auth.Role;
import com.aleksgolovnya.deansoffice.entity.auth.State;
import com.aleksgolovnya.deansoffice.entity.auth.User;
import com.aleksgolovnya.deansoffice.forms.UserForm;
import com.aleksgolovnya.deansoffice.repository.auth.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void addUser(UserForm userForm) {
        String hashPassword = passwordEncoder.encode(userForm.getPassword());

        if (userForm.getStudentId() != null) {
            User studentUser = User.builder()
                    .email(userForm.getEmail())
                    .password(userForm.getPassword())
                    .studentId(userForm.getStudentId())
                    .role(Role.STUDENT)
                    .state(State.ACTIVE)
                    .build();

            userRepository.saveAndFlush(studentUser);
        } else {
            User teacherUser = User.builder()
                    .email(userForm.getEmail())
                    .password(userForm.getPassword())
                    .teacherId(userForm.getTeacherId())
                    .role(Role.TEACHER)
                    .state(State.ACTIVE)
                    .build();

            userRepository.saveAndFlush(teacherUser);
        }
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User getById(Long id) {
        return userRepository.getOne(id);
    }
}
