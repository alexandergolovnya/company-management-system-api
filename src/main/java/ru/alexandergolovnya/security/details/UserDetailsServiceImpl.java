package ru.alexandergolovnya.security.details;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.alexandergolovnya.domain.repository.UserRepository;

/**
 * @author: Alexander Golovnya <mail@alexandergolovnya.ru>
 * @created: 2019/09/04
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    /**
     * Method returns user by its email
     * @param email of the user
     * @return User
     * @throws UsernameNotFoundException if user with such email doesn't consist in database
     */
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return new
                UserDetailsImpl(userRepository.findOneByEmail(email)
                .orElseThrow(IllegalArgumentException::new));
    }
}
