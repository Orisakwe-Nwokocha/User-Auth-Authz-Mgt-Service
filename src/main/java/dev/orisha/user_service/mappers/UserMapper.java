package dev.orisha.user_service.mappers;

import dev.orisha.user_service.data.models.User;
import dev.orisha.user_service.dto.UserDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper extends EntityMapper<UserDTO, User> {}
