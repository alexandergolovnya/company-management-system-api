package com.universityspa.service.auth;

import com.universityspa.dto.auth.TokenDto;
import com.universityspa.dto.forms.LoginForm;

import javax.security.auth.login.FailedLoginException;
import javax.security.sasl.AuthenticationException;

/**
 * Service provides sign in operation
 */
public interface LoginService {

    TokenDto login(LoginForm loginForm) throws AuthenticationException;
}
