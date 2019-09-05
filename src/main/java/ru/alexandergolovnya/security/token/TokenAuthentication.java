package ru.alexandergolovnya.security.token;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * @author: Alexander Golovnya <mail@alexandergolovnya.ru>
 * @created: 2019/09/04
 */
public class TokenAuthentication implements Authentication {

    /**
     * Token for user
     */
    private String token;

    /**
     * Parameter for checking if user is authenticated
     */
    private boolean isAuthenticated;

    /**
     * User details
     */
    private UserDetails userDetails;

    /**
     * Constructor
     * @param token
     */
    public TokenAuthentication(String token) {
        this.token = token;
    }

    /**
     * Setter-method for user details
     * @param userDetails
     */
    public void setUserDetails(UserDetails userDetails) {
        this.userDetails = userDetails;
    }

    /**
     * Method returns the authorities granted to the user
     * @return collection of roles
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return userDetails.getAuthorities();
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
     * Getter-method for user details
     * @return
     */
    @Override
    public Object getDetails() {
        return userDetails;
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
     * Getter-method for isAuthenticated parameter
     * @return isAuthenticated
     */
    @Override
    public boolean isAuthenticated() {
        return isAuthenticated;
    }

    /**
     * Setter-method for isAuthenticated parameter
     * @param isAuthenticated
     * @throws IllegalArgumentException
     */
    @Override
    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
        this.isAuthenticated  = isAuthenticated;
    }

    /**
     * Getter-method for token
     * @return token
     */
    @Override
    public String getName() {
        return token;
    }
}
