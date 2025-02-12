package dev.orisha.user_service.controllers;

import dev.orisha.user_service.dto.UserDTO;
import dev.orisha.user_service.dto.requests.UserUpdateRequest;
import dev.orisha.user_service.dto.responses.ApiResponse;
import dev.orisha.user_service.services.UserService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

import static dev.orisha.user_service.config.constants.AppConstants.USER_AUTHORITY;
import static dev.orisha.user_service.controllers.constants.ApplicationUrls.*;
import static dev.orisha.user_service.exceptions.constants.ErrorConstants.ACCESS_DENIED;
import static java.time.LocalDateTime.now;

@RestController
@RequestMapping(BASE_CONTEXT_URL)
@Slf4j
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(final UserService userService) {
        this.userService = userService;
    }


    @GetMapping("")
    public String home(Principal principal) {
        return "Hello %s!".formatted(principal != null ? principal.getName() : "World");
    }

    @GetMapping(GET_USER_BY_EMAIL_URL)
    public ResponseEntity<?> getUserByEmail(@RequestParam String email, Principal principal) {
        if (email.equals(principal.getName())) {
            log.info("REST request to get user: {}", principal.getName());
            UserDTO userDTO = userService.getUser(email);
            return buildApiResponse(userDTO);
        }

        throw new AccessDeniedException(ACCESS_DENIED);
    }

    @PatchMapping(UPDATE_USER_URL)
    @Secured(USER_AUTHORITY)
//    @RolesAllowed({ADMIN_AUTHORITY})
//    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> updateUser(@Valid @RequestBody UserUpdateRequest request, Principal principal) {
        log.info("REST request to update user with dto: {}", request);
        String user = request.getEmail();
        String authenticatedUser = principal.getName();
        if (user == null || !user.equals(authenticatedUser)) {
            log.error("Authenticated user '{}' is not permitted to update user '{}'", authenticatedUser, user);
            throw new AccessDeniedException(ACCESS_DENIED);
        }

        UserDTO updatedUser = userService.updateUser(request);
        log.info("User updated: {}", updatedUser);
        return buildApiResponse(updatedUser);
    }

    @GetMapping(GET_ALL_USERS_URL)
    public ResponseEntity<?> getUsers() {
        log.info("REST request to get all users");
        List<UserDTO> users = userService.getAllUsers();
        return buildApiResponse(users);
    }

    private <T> ResponseEntity<?> buildApiResponse(T data) {
        return ResponseEntity.ok(new ApiResponse<>(now(), true, data));
    }

}
