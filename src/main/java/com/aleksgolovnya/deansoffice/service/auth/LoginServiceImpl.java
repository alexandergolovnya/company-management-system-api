package com.aleksgolovnya.deansoffice.service.auth;

import com.aleksgolovnya.deansoffice.dto.auth.TokenDto;
import com.aleksgolovnya.deansoffice.entity.auth.Token;
import com.aleksgolovnya.deansoffice.entity.auth.User;
import com.aleksgolovnya.deansoffice.forms.LoginForm;
import com.aleksgolovnya.deansoffice.repository.auth.TokenRepository;
import com.aleksgolovnya.deansoffice.repository.auth.UserRepository;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static com.aleksgolovnya.deansoffice.dto.auth.TokenDto.from;

public class LoginServiceImpl implements LoginService {

    @Autowired
    private TokenRepository tokenRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public TokenDto login(LoginForm loginForm) {
        Optional<User> userToLogin = userRepository.findOneByEmail(loginForm.getEmail());

        if (userToLogin.isPresent()) {
            User user = userToLogin.get();

            if (passwordEncoder.matches(loginForm.getPassword(), user.getPassword())) {
                Token token = Token.builder()
                        .user(user)
                        .value(RandomStringUtils.random(10, true, true))
                        .build();

                tokenRepository.saveAndFlush(token);
                return from(token);
            }
        } throw new IllegalArgumentException("User not found");
    }
}
