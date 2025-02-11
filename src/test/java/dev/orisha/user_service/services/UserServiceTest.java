package dev.orisha.user_service.services;

import dev.orisha.user_service.dto.UserDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Sql("/db/data.sql")
class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    void update() {
    }

    @Test
    void getUserDTO() {
    }

    @Test
    void getAllUsers() {
        List<UserDTO> allUsers = userService.getAllUsers();
        System.out.println(allUsers);
        assertNotNull(allUsers);
        assertFalse(allUsers.isEmpty());
    }
}