package dev.orisha.user_service.services;

import dev.orisha.user_service.dto.PageData;
import dev.orisha.user_service.dto.UserDTO;
import dev.orisha.user_service.dto.requests.UserUpdateRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {

    UserDTO getUser(String email);

    UserDTO updateUser(UserUpdateRequest request);

    List<UserDTO> getAllUsers();

    PageData<UserDTO> getAllUsers(Pageable pageable);

}
