package dev.orisha.user_service.services;

import dev.orisha.user_service.dto.PageData;
import dev.orisha.user_service.dto.UserDTO;
import dev.orisha.user_service.dto.requests.UserUpdateRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static dev.orisha.user_service.data.enums.Authority.ADMIN;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@Sql("/db/data.sql")
class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    void getUserTest() {
        String email = "user";
        UserDTO userDTO = userService.getUser(email);
        assertNotNull(userDTO);
        assertThat(userDTO.getEmail()).isEqualTo(email);
    }

    @Test
    void updateUserTest() {
        UserUpdateRequest request = getUserUpdateRequest();
        UserDTO user = userService.getUser(request.getEmail());
        int size = user.getAuthorities().size();
        assertThat(size).isEqualTo(1);
        assertThat(user.getFirstName()).isNullOrEmpty();

        UserDTO update = userService.updateUser(request);

        assertNotNull(update);
        user = userService.getUser(request.getEmail());
        size = user.getAuthorities().size();
        assertThat(size).isEqualTo(2);
        assertThat(user.getFirstName()).isEqualTo(request.getFirstName());
    }

    @Test
    void getAllUsersTest() {
        List<UserDTO> allUsers = userService.getAllUsers();
        assertThat(allUsers).isNotNull();
        System.out.println(allUsers);
        assertThat(allUsers).isNotEmpty();
    }

    @Test
    void getAllUsersPageTest() {
        Pageable pageable = PageRequest.of(0, 5);
        PageData<UserDTO> allUsers = userService.getAllUsers(pageable);
        assertThat(allUsers).isNotNull();
        assertThat(allUsers.getContent()).isNotEmpty();
        assertThat(allUsers.getTotalElements()).isGreaterThanOrEqualTo(2);
    }

    private static UserUpdateRequest getUserUpdateRequest() {
        UserUpdateRequest request = new UserUpdateRequest();
        request.setEmail("user");
        request.setFirstName("firstname");
        request.setAuthority(ADMIN);
        return request;
    }

}