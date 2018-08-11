package com.universityspa.security.provider;

import com.universityspa.entity.auth.Token;
import com.universityspa.repository.auth.TokenRepository;
import com.universityspa.security.token.TokenAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class TokenAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private TokenRepository tokenRepository;

    @Qualifier("userDetailsServiceImpl")
    @Autowired
    private UserDetailsService userDetailsService;

    /**
     * Method processes token and connect user to this token
     * @param authentication
     * @return tokenAuthentication
     * @throws AuthenticationException
     */
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        TokenAuthentication tokenAuthentication = (TokenAuthentication) authentication;

        Optional<Token> token = tokenRepository.findOneByValue(tokenAuthentication.getName());

        if (token.isPresent()) {
            UserDetails userDetails = userDetailsService.loadUserByUsername(token.get().getUser().getEmail());
            tokenAuthentication.setUserDetails(userDetails);
            tokenAuthentication.setAuthenticated(true);
            return tokenAuthentication;
        } else throw new IllegalArgumentException("Bad token");
    }

    /**
     * Supports method for Token Authentication class
     * @param authentication
     * @return
     */
    @Override
    public boolean supports(Class<?> authentication) {
        return TokenAuthentication.class.equals(authentication);
    }
}
