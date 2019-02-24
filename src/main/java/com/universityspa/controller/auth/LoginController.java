package com.universityspa.controller.auth;

import com.universityspa.dto.auth.TokenDto;
import com.universityspa.dto.forms.LoginForm;
import com.universityspa.service.auth.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.security.auth.login.FailedLoginException;
import javax.security.sasl.AuthenticationException;

/**
 * REST controller for user sign in
 */

@RestController
@RequestMapping("/api")
public class LoginController {

    @Autowired
    private LoginService loginService;

    /**
     * Method provides login service for user
     * @param loginForm
     * @return
     */
    @PostMapping("/login")
    public ResponseEntity<TokenDto> login(@RequestBody LoginForm loginForm) throws AuthenticationException {
        return ResponseEntity.ok(loginService.login(loginForm));
    }
}
