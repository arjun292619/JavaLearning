package net.javaguides.spring_user_rest_service.service;

import net.javaguides.spring_user_rest_service.dto.UserDto;
import net.javaguides.spring_user_rest_service.entity.User;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto user);

    UserDto getUserById(Long userId);

    List<UserDto> getAllUsers();

    UserDto updateUser(Long userId, UserDto userDto);

    void deleteUser(Long userId);
}
