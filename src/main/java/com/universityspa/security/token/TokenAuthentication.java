package com.universityspa.security.token;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class TokenAuthentication implements Authentication {

    /**
     * Token for user
     */
    private String token;

    /**
     * Parameter for checking if user is authenticated
     */
    private Boolean isAuthenticated;

    /**
     * User details
     */
    private UserDetails userDetails;

    /**
     * Method returns the authorities granted to the user
     * @return collection of roles
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return userDetails.getAuthorities();
    }

    /**
     * Setter-method for user details
     * @param userDetails
     */
    public void setUserDetails(UserDetails userDetails) {
        this.userDetails = userDetails;
    }

    /**
     * Setter-method for isAuthenticated parameter
     * @param b
     * @throws IllegalArgumentException
     */
    @Override
    public void setAuthenticated(boolean b) throws IllegalArgumentException {
        this.isAuthenticated = isAuthenticated;
    }

    /**
     * Getter-method for user details
     * @return
     */
    @Override
    public Object getDetails() {
        return userDetails;
    }

    /**
     * Getter-method for isAuthenticated parameter
     * @return isAuthenticated
     */
    @Override
    public boolean isAuthenticated() {
        return isAuthenticated;
    }

    /**
     * Getter-mathod for token
     * @return token
     */
    @Override
    public String getName() {
        return token;
    }

    /**
     * (!) Method is hard coded, we don't use this feature in current version
     * @return
     */
    @Override
    public Object getCredentials() {
        return null;
    }

    /**
     * (!) Method is hard coded, we don't use this feature in current version
     * @return
     */
    @Override
    public Object getPrincipal() {
        return null;
    }

    /**
     * Constructor
     * @param token
     */
    public TokenAuthentication(String token) {
        this.token = token;
    }
}
