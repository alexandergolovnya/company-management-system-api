package com.universityspa.service.auth;

import com.universityspa.dto.auth.AuthLoginResponseDto;
import com.universityspa.dto.auth.UserDto;
import com.universityspa.dto.forms.LoginForm;
import com.universityspa.dto.forms.UserForm;
import com.universityspa.entity.auth.Role;
import com.universityspa.entity.auth.State;
import com.universityspa.entity.auth.Token;
import com.universityspa.entity.auth.User;
import com.universityspa.exception.EmptyRequestDataException;
import com.universityspa.exception.NotFoundException;
import com.universityspa.exception.NotUniqueCredentialsException;
import com.universityspa.repository.auth.TokenRepository;
import com.universityspa.repository.auth.UserRepository;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.universityspa.dto.auth.UserDto.convertFromEntityToDTO;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private TokenRepository tokenRepository;

    /**
     * Method performs an authorization of the user
     * It checks email and password of the user
     * and if they correspond to the data in the database
     * method generates token for this user
     *
     * @param loginForm - data convertFromEntityToDTO the form: email and password
     * @return Token
     * @throws IllegalArgumentException if such user doesn't exist
     */
    @Override
    public AuthLoginResponseDto login(LoginForm loginForm) {
        Optional<User> userToLogin = userRepository.findOneByEmail(loginForm.getEmail());

        if (userToLogin.isPresent()) {
            User user = userToLogin.get();

            if (passwordEncoder.matches(loginForm.getPassword(), user.getPassword())) {
                Token token = Token.builder()
                        .user(user)
                        .token(RandomStringUtils.random(40, true, true))
                        .build();

                tokenRepository.saveAndFlush(token);
                return AuthLoginResponseDto.convertTokenAndUserEntityToDto(token, user);
            } else throw new IllegalArgumentException("Incorrect password");
        }
        throw new IllegalArgumentException("User not found");
    }

    /**
     * Method creates new user without admin rules.
     * It checks received data at userForm for not null
     * uniqueness of the received email
     *
     * @param userForm - data from the sign up form: email and password, first, middle and last name
     * @return userDto
     * @throws NotUniqueCredentialsException if email of the user already exist
     * @throws EmptyRequestDataException if email, password received in userForm are null
     */
    @Override
    public UserDto createUser(UserForm userForm) throws NotUniqueCredentialsException, EmptyRequestDataException {

        if (userForm.getEmail() != null && userForm.getPassword() != null) {
            Optional<User> existUser = userRepository.findOneByEmail(userForm.getEmail());

            if (existUser.isPresent()) {
                throw new NotUniqueCredentialsException("Пользователь с таким email уже зарегистрирован");
            } else {
                String hashPassword = passwordEncoder.encode(userForm.getPassword());
                User user = User.builder()
                        .email(userForm.getEmail())
                        .password(hashPassword)
                        .firstName(userForm.getFirstName())
                        .middleName(userForm.getMiddleName())
                        .lastName(userForm.getLastName())
                        .role(Role.ROLE_USER)
                        .state(State.ACTIVE)
                        .build();
                userRepository.saveAndFlush(user);

                return convertFromEntityToDTO(user);
            }
        } else throw new EmptyRequestDataException("Для регистрации необходимо ввести email и пароль");
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
    @Override
    public UserDto editUser(Long id, UserDto userDto) throws NotFoundException {

        User userToEdit = userRepository.getOne(id);

        if (userToEdit != null) {
            User user = User.builder()
                    .email(userDto.getEmail())
                    .firstName(userDto.getFirstName())
                    .middleName(userDto.getMiddleName())
                    .lastName(userDto.getLastName())
                    .role(userDto.getRole())
                    .studentGroupId(userDto.getStudentGroupID())
                    .departmentId(userDto.getDepartmentId())
                    .build();
            userRepository.saveAndFlush(user);
            return convertFromEntityToDTO(user);
        } else {
            throw new NotFoundException("Such user doesn't exist");
        }
    }

    /**
     * Methods deletes user from the database
     *
     * @param id of the user
     * @throws NotFoundException if user doesn't exist
     */
    @Override
    public void deleteUserFromDatabase(Long id) throws NotFoundException {
        User userToDelete = userRepository.getOne(id);

        if (userToDelete != null) {
            userRepository.delete(userToDelete);
        } else {
            throw new NotFoundException("Such user doesn't exist");
        }
    }

    /**
     * Methods set deleted state for user
     *
     * @param id of the user
     * @throws NotFoundException if user doesn't exist
     */
    @Override
    public void setDeletedState(Long id) throws NotFoundException {
        User userToDelete = userRepository.getOne(id);

        if (userToDelete != null) {
            userToDelete = User.builder()
                    .state(State.DELETED)
                    .build();
            userRepository.saveAndFlush(userToDelete);
        } else {
            throw new NotFoundException("Such user doesn't exist");
        }
    }

    /**
     * Method receives all users with pagination
     *
     * @param pageable
     * @return userDtoPage
     */
    @Override
    public Page<UserDto> getAll(Pageable pageable) {
        Page<User> userPage = userRepository.findAll(pageable);
        int totalElements = (int) userPage.getTotalElements();
        List<UserDto> userDtoList = userPage
                .getContent()
                .stream()
                .map(user -> convertFromEntityToDTO(user))
                .collect(Collectors.toList());

        Page<UserDto> userDtoPage = new PageImpl<>(userDtoList, pageable, totalElements);
        return userDtoPage;
    }

    /**
     * Method returns user by id
     *
     * @param id of the user
     * @return UserDto
     * @throws NotFoundException if user doesn't exist
     */
    @Override
    public UserDto getById(Long id) throws NotFoundException {
        User user = userRepository.getOne(id);

        if (user != null) {
            return convertFromEntityToDTO(user);
        } else {
            throw new NotFoundException("Such user doesn't exist");
        }
    }

    /**
     * Method returns all students for student group with pagination
     *
     * @param id       of the student group
     * @param pageable
     * @return list of students from student group by id
     */
    @Override
    public Page<UserDto> getStudentGroupStudents(Long id, Pageable pageable) {
        Page<User> studentPage = userRepository.findAllByStudentGroupId(id, pageable);
        int totalElements = (int) studentPage.getTotalElements();
        List<UserDto> studentDtoList = studentPage
                .getContent()
                .stream()
                .map(student -> convertFromEntityToDTO(student))
                .collect(Collectors.toList());

        Page<UserDto> studentDtoPage = new PageImpl<>(studentDtoList, pageable, totalElements);
        return studentDtoPage;
    }

    /**
     * Method receives all teachers for department with pagination
     *
     * @param id of the department
     * @return list of teachers from department by id
     */
    @Override
    public Page<UserDto> getDepartmentTeachers(Long id, Pageable pageable) {
        Page<User> teacherPage = userRepository.findAllByDepartmentId(id, pageable);
        int totalElements = (int) teacherPage.getTotalElements();
        List<UserDto> teacherDtoList = teacherPage
                .getContent()
                .stream()
                .map(teacher -> convertFromEntityToDTO(teacher))
                .collect(Collectors.toList());

        Page<UserDto> teacherDtoPage = new PageImpl<>(teacherDtoList, pageable, totalElements);
        return teacherDtoPage;
    }
}
