package com.universityspa.service.auth;

import com.universityspa.dto.auth.TokenDto;
import com.universityspa.entity.auth.Token;
import com.universityspa.entity.auth.User;
import com.universityspa.forms.LoginForm;
import com.universityspa.repository.auth.TokenRepository;
import com.universityspa.repository.auth.UserRepository;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

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
                return TokenDto.from(token);
            }
        } throw new IllegalArgumentException("User not found");
    }
}
