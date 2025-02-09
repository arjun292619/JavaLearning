package net.javaguides.spring_user_rest_service.mapper;

import net.javaguides.spring_user_rest_service.dto.UserDto;
import net.javaguides.spring_user_rest_service.entity.User;

public class UserMapper {
    //    convert User JPA Entity to UserDto
    public static UserDto mapToUserDto(User user) {
        UserDto userDto = new UserDto(user.getId(), user.getFirstName(), user.getLastName(), user.getEmail());
        return userDto;
    }

    //    convert UserDto to User JPA Entity
    public static User mapToUser(UserDto userDto) {
        User user = new User(userDto.getUserId(), userDto.getFname(), userDto.getLname(), userDto.getEmail());
        return user;
    }
}
