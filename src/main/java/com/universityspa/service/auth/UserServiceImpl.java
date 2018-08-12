package com.universityspa.service.auth;

import com.universityspa.dto.auth.UserDto;
import com.universityspa.entity.auth.Role;
import com.universityspa.entity.auth.State;
import com.universityspa.entity.auth.User;
import com.universityspa.exception.EmptyRequestDataException;
import com.universityspa.exception.NotFoundException;
import com.universityspa.exception.NotUniqueCredentialsException;
import com.universityspa.dto.forms.UserForm;
import com.universityspa.repository.auth.UserRepository;
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

    /**
     * Method creates new user with Student role.
     * It checks received data at userForm for not null
     * uniqueness of the received email and parameter teacherId to be not specified
     *
     * @param userForm - data convertFromEntityToDTO the sign up form: email and password
     * @return userDto
     * @throws NotUniqueCredentialsException if email of the user already exist or if teacherId is specified
     * @throws EmptyRequestDataException if email, password or studentId receiver in userForm are null
     */
    @Override
    public UserDto createStudentUser(UserForm userForm) throws NotUniqueCredentialsException, EmptyRequestDataException {

        if (userForm.getEmail() != null && userForm.getPassword() != null) {
            Optional<User> existUser = userRepository.findOneByEmail(userForm.getEmail());

            if (existUser.isPresent()) {
                throw new NotUniqueCredentialsException("User with such email already exist");
            } else if (userForm.getTeacherId() != null) {
                throw new NotUniqueCredentialsException("This user already belongs to teacher");
            } else if (userForm.getStudentId() != null){
                String hashPassword = passwordEncoder.encode(userForm.getPassword());
                User studentUser = User.builder()
                        .email(userForm.getEmail())
                        .password(hashPassword)
                        .studentId(userForm.getStudentId())
                        .role(Role.STUDENT)
                        .state(State.ACTIVE)
                        .build();
                userRepository.saveAndFlush(studentUser);

                return convertFromEntityToDTO(studentUser);
            } else throw new EmptyRequestDataException("There are no specified student for this user");
        } else throw new EmptyRequestDataException("There are no specified email or password");
    }

    /**
     * Method creates new user with Teacher role.
     * It checks received data at userForm for not null
     * uniqueness of the received email and parameter studentId to be not specified
     *
     * @param userForm - data convertFromEntityToDTO the sign up form: email and password
     * @return userDto
     * @throws NotUniqueCredentialsException if email of the user already exist or if teacherId is specified
     * @throws EmptyRequestDataException if email, password or studentId receiver in userForm are null
     */
    @Override
    public UserDto createTeacherUser(UserForm userForm) throws NotUniqueCredentialsException, EmptyRequestDataException {

        if (userForm.getEmail() != null && userForm.getPassword() != null) {
            Optional<User> existUser = userRepository.findOneByEmail(userForm.getEmail());

            if (existUser.isPresent()) {
                throw new NotUniqueCredentialsException("User with such email already exist");
            } else if (userForm.getStudentId() != null) {
                throw new NotUniqueCredentialsException("This user already belongs to student");
            } else if (userForm.getTeacherId() != null){
                String hashPassword = passwordEncoder.encode(userForm.getPassword());
                User teacherUser = User.builder()
                        .email(userForm.getEmail())
                        .password(hashPassword)
                        .teacherId(userForm.getTeacherId())
                        .role(Role.TEACHER)
                        .state(State.ACTIVE)
                        .build();
                userRepository.saveAndFlush(teacherUser);

                return convertFromEntityToDTO(teacherUser);
            } else throw new EmptyRequestDataException("There are no specified teacher for this user");
        } else throw new EmptyRequestDataException("There are no specified email or password");
    }

    /**
     * (!) Method for developers version, should be switch of in production
     * Method creates new user with Admin role.
     * It checks received data at userForm for not null and
     * uniqueness of the received email
     *
     * @param userForm - data convertFromEntityToDTO the sign up form: email and password
     * @return userDto
     * @throws NotUniqueCredentialsException if email of the user already exist
     * @throws EmptyRequestDataException if email or password receiver in userForm are null
     */
    @Override
    public UserDto createAdminUser(UserForm userForm) throws NotUniqueCredentialsException, EmptyRequestDataException {

        if (userForm.getEmail() != null && userForm.getPassword() != null) {
            Optional<User> existUser = userRepository.findOneByEmail(userForm.getEmail());

            if (existUser.isPresent()) {
                throw new NotUniqueCredentialsException("User with such email already exist");
            } else {
                String hashPassword = passwordEncoder.encode(userForm.getPassword());
                User adminUser = User.builder()
                        .email(userForm.getEmail())
                        .password(hashPassword)
                        .role(Role.ADMIN)
                        .state(State.ACTIVE)
                        .build();
                userRepository.saveAndFlush(adminUser);
                return convertFromEntityToDTO(adminUser);
            }
        } else throw new EmptyRequestDataException("There are no specified email or password");
    }

    /**
     * Method edits email and password of user
     *
     * @param id of the user
     * @param userForm - received data: email and password
     * @return userDto
     * @throws EmptyRequestDataException
     */
    @Override
    public UserDto editUser(Long id, UserForm userForm) throws NotFoundException {

        User userToEdit = userRepository.getOne(id);

        if (userToEdit != null) {
            String hashPassword = passwordEncoder.encode(userForm.getPassword());
            User user = User.builder()
                    .email(userForm.getEmail())
                    .password(hashPassword)
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
}
