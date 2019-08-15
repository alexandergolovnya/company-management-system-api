package ru.alexandergolovnya.security.details;

import ru.alexandergolovnya.domain.entity.user.State;
import ru.alexandergolovnya.domain.entity.user.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class UserDetailsImpl implements UserDetails {

    /**
     * User
     */
    private User user;

    /**
     * Method returns the authorities granted to the user
     * @return collection of roles
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        String userRole = user.getRole().name();
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(userRole);
        return Collections.singletonList(authority);
    }

    /**
     * (!) Method is hard coded, we don't use this feature in current version
     * Method checks that user account is not expired
     * @return true - if is not expired, false - if is expired
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * Method checks that users account is not banned
     * @return true - if not banned, false - if is banned
     */
    @Override
    public boolean isAccountNonLocked() {
        return !user.getState().equals(State.BANNED);
    }

    /**
     * (!) Method is hard coded, we don't use this feature in current version
     * Method checks that user account credentials is not expired
     * @return true - if is not expired, false - if is expired
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * Method checks that users account is active
     * @return true - if user is active, false - if user is banned or deleted
     */
    @Override
    public boolean isEnabled() {
        return user.getState().equals(State.ACTIVE);
    }

    /**
     * Constructor
     * @param user
     */
    public UserDetailsImpl(User user) {
        this.user = user;
    }

    /**
     * Getter-method for password
     * @return password
     */
    @Override
    public String getPassword() {
        return user.getPassword();
    }

    /**
     * Getter-method for email
     * @return email
     */
    @Override
    public String getUsername() {
        return user.getEmail();
    }

    /**
     * Getter-method for user
     * @return User
     */
    public User getUser() {
        return user;
    }
}
