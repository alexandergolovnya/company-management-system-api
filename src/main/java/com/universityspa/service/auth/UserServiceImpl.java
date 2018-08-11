package com.universityspa.service.auth;

import com.universityspa.entity.auth.Role;
import com.universityspa.entity.auth.State;
import com.universityspa.entity.auth.User;
import com.universityspa.forms.UserForm;
import com.universityspa.repository.auth.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void addUser(UserForm userForm) {
        String hashPassword = passwordEncoder.encode(userForm.getPassword());

        if (userForm.getTeacherId() != null) {
            User teacherUser = User.builder()
                    .email(userForm.getEmail())
                    .password(hashPassword)
                    .teacherId(userForm.getTeacherId())
                    .role(Role.TEACHER)
                    .state(State.ACTIVE)
                    .build();

            userRepository.saveAndFlush(teacherUser);
        } else {
            User studentUser = User.builder()
                    .email(userForm.getEmail())
                    .password(hashPassword)
                    .studentId(userForm.getStudentId())
                    .role(Role.STUDENT)
                    .state(State.ACTIVE)
                    .build();

            userRepository.saveAndFlush(studentUser);
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
