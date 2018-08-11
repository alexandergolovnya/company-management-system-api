package com.universityspa.service.auth;

import com.universityspa.dto.auth.TokenDto;
import com.universityspa.forms.LoginForm;

public interface LoginService {

    TokenDto login(LoginForm loginForm);
}
