package com.aleksgolovnya.deansoffice.service.auth;

import com.aleksgolovnya.deansoffice.dto.auth.TokenDto;
import com.aleksgolovnya.deansoffice.forms.LoginForm;

public interface LoginService {

    TokenDto login(LoginForm loginForm);
}
