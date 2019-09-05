package ru.alexandergolovnya.service.auth;

import org.apache.commons.lang.RandomStringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.alexandergolovnya.domain.dto.UserDto;
import ru.alexandergolovnya.domain.entity.user.Role;
import ru.alexandergolovnya.domain.entity.user.State;
import ru.alexandergolovnya.domain.entity.user.Token;
import ru.alexandergolovnya.domain.entity.user.User;
import ru.alexandergolovnya.domain.repository.TokenRepository;
import ru.alexandergolovnya.domain.repository.UserRepository;
import ru.alexandergolovnya.domain.request.LoginRequest;
import ru.alexandergolovnya.domain.request.SignUpRequest;
import ru.alexandergolovnya.exception.EmptyRequestDataException;
import ru.alexandergolovnya.exception.NotFoundException;
import ru.alexandergolovnya.exception.NotUniqueCredentialsException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static ru.alexandergolovnya.utils.ObjectMapperUtils.map;

/**
 * @author: Alexander Golovnya <mail@alexandergolovnya.ru>
 * @created: 2019/09/04
 */
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenRepository tokenRepository;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, TokenRepository tokenRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.tokenRepository = tokenRepository;
    }

    /**
     * Method performs an authorization of the user
     * It checks email and password of the user
     * and if they correspond to the data in the database
     * method generates token for this user
     *
     * @param loginRequest - data convertFromEntityToDTO the form: email and password
     * @return Token
     * @throws IllegalArgumentException if such user doesn't exist
     */
    @Override
    public UserDto login(LoginRequest loginRequest) {
        Optional<User> userToLogin = userRepository.findOneByEmail(loginRequest.getEmail());

        if (userToLogin.isPresent()) {
            User user = userToLogin.get();

            if (passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
                Token token = Token.builder()
                        .user(user)
                        .token(RandomStringUtils.random(40, true, true))
                        .build();

                tokenRepository.save(token);
                UserDto userDto = UserDto.convertFromEntityToDTO(user);
                userDto.setToken(token.getToken());
                if (user.getDepartmentId() != null) {
                    userDto.setDepartmentId(user.getDepartmentId());
                }
                return userDto;
            } else throw new IllegalArgumentException("Incorrect password");
        }
        throw new IllegalArgumentException("User not found");
    }

    /**
     * Method creates new user with provided role.
     * It checks received data at userForm for not null
     * uniqueness of the received email
     *
     * @param request - data from the sign up form: email and password, first, middle and last name
     * @return userDto
     * @throws NotUniqueCredentialsException if email of the user already exist
     * @throws EmptyRequestDataException if email, password received in userForm are null
     */
    @Override
    public UserDto createUser(SignUpRequest request) throws NotUniqueCredentialsException, EmptyRequestDataException {

        if (request.getEmail() != null && request.getPassword() != null) {
            Optional<User> existUser = userRepository.findOneByEmail(request.getEmail());
//            Department department = departmentRepository.getOne(request.getDepartmentId());

            if (existUser.isPresent()) {
                throw new NotUniqueCredentialsException("Пользователь с таким email уже зарегистрирован");
            } else {
                String hashPassword = passwordEncoder.encode(request.getPassword());
                User user = User.builder()
                        .email(request.getEmail())
                        .password(hashPassword)
                        .firstName(request.getFirstName())
                        .middleName(request.getMiddleName())
                        .lastName(request.getLastName())
                        .role(Role.valueOf(request.getRoleName()))
                        .departmentId(request.getDepartmentId())
                        .photo(request.getPhoto())
                        .description(request.getDescription())
                        .state(State.ACTIVE)
                        .build();
                userRepository.save(user);

                return UserDto.convertFromEntityToDTO(user);
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
    public UserDto editUser(int id, UserDto userDto) throws NotFoundException {

        User userToEdit = userRepository.getOne(id);

        if (userToEdit != null) {
            User user = User.builder()
                    .email(userDto.getEmail())
                    .firstName(userDto.getFirstName())
                    .middleName(userDto.getMiddleName())
                    .lastName(userDto.getLastName())
                    .role(userDto.getRole())
                    .departmentId(userDto.getDepartmentId())
                    .state(State.ACTIVE)
                    .build();
            userRepository.save(user);

            return map(user, UserDto.class);
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
    public void deleteUserFromDatabase(int id) throws NotFoundException {
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
    public void setDeletedState(int id) throws NotFoundException {
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
        return getUserDtoList(pageable, userPage);
    }

    /**
     * Method returns user by id
     *
     * @param id of the user
     * @return UserDto
     * @throws NotFoundException if user doesn't exist
     */
    @Override
    public UserDto getById(int id) throws NotFoundException {
        User user = userRepository.getOne(id);

        if (user != null) {
            UserDto userDto = UserDto.convertFromEntityToDTO(user);
            if (user.getDepartmentId() != null) {
                userDto.setDepartmentId(user.getDepartmentId());
            }
            return userDto;
        } else {
            throw new NotFoundException("Such user doesn't exist");
        }
    }

    /**
     * Method receives all employees for department with pagination
     *
     * @param id of the department
     * @return list of employees from department by id
     */
    @Override
    public Page<UserDto> getDepartmentEmployees(int id, Pageable pageable) {
        Page<User> departmentUsers = userRepository.findAllByDepartmentId(id, pageable);
        return getUserDtoList(pageable, departmentUsers);
    }

    private Page<UserDto> getUserDtoList(Pageable pageable, Page<User> departmentUsers) {
        int totalElements = (int) departmentUsers.getTotalElements();
        List<UserDto> userDtoList = departmentUsers
                .getContent()
                .stream()
                .map(user -> {
                    UserDto userDto = UserDto.convertFromEntityToDTO(user);
                    if (user.getDepartmentId() != null) {
                        userDto.setDepartmentId(user.getDepartmentId());
                    }
                    return userDto;
                })
                .collect(Collectors.toList());

        return new PageImpl<>(userDtoList, pageable, totalElements);
    }
}
