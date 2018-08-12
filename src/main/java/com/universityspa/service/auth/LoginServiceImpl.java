package com.universityspa.service.auth;

import com.universityspa.dto.auth.TokenDto;
import com.universityspa.entity.auth.Token;
import com.universityspa.entity.auth.User;
import com.universityspa.dto.forms.LoginForm;
import com.universityspa.repository.auth.TokenRepository;
import com.universityspa.repository.auth.UserRepository;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Service provides sign in operation
 */

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private TokenRepository tokenRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

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
    public TokenDto login(LoginForm loginForm) {
        Optional<User> userToLogin = userRepository.findOneByEmail(loginForm.getEmail());

        if (userToLogin.isPresent()) {
            User user = userToLogin.get();

            if (passwordEncoder.matches(loginForm.getPassword(), user.getPassword())) {
                Token token = Token.builder()
                        .user(user)
                        .value(RandomStringUtils.random(40, true, true))
                        .build();

                tokenRepository.saveAndFlush(token);
                return TokenDto.from(token);
            }
        } throw new IllegalArgumentException("User not found");
    }
}
