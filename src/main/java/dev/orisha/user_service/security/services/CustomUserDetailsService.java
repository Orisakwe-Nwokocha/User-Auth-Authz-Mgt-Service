package dev.orisha.user_service.security.services;

import dev.orisha.user_service.dto.UserDTO;
import dev.orisha.user_service.security.data.models.SecureUser;
import dev.orisha.user_service.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import static dev.orisha.user_service.exceptions.constants.ErrorConstants.AUTHENTICATION_ERROR_MESSAGE;

@Service
@Slf4j
public class CustomUserDetailsService implements UserDetailsService {

    private final UserService userService;

    @Autowired
    public CustomUserDetailsService(final UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("Loading user: {}", username);
        try {
            UserDTO user = userService.getUser(username);
            log.info("User found with email: {}", user.getEmail());
            return new SecureUser(user);
        } catch (Exception e) {
            log.error("[-] Error: {}", e.getMessage(), e);
            throw new UsernameNotFoundException(AUTHENTICATION_ERROR_MESSAGE);
        }
    }
}
