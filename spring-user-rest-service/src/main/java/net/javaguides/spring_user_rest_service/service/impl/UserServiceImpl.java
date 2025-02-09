package net.javaguides.spring_user_rest_service.service.impl;

import lombok.AllArgsConstructor;
import net.javaguides.spring_user_rest_service.dto.UserDto;
import net.javaguides.spring_user_rest_service.entity.User;
import net.javaguides.spring_user_rest_service.exception.EmailAlreadyExistsException;
import net.javaguides.spring_user_rest_service.exception.ResourceNotFoundException;
import net.javaguides.spring_user_rest_service.mapper.UserMapper;
import net.javaguides.spring_user_rest_service.mapper.UserMapperStruct;
import net.javaguides.spring_user_rest_service.repository.UserRepository;
import net.javaguides.spring_user_rest_service.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto userDto) {
        Optional<User> tempUser = userRepository.findByEmail(userDto.getEmail());
        if (tempUser.isPresent()) throw new EmailAlreadyExistsException("Email already exists");
//        convert UserDto to UserDao
        User convertedUser = UserMapper.mapToUser(userDto);

        User savedUser = userRepository.save(convertedUser);

        //        convert UserDAO to UserDTO
        UserDto tempUserDto = UserMapper.mapToUserDto(savedUser);
        return tempUserDto;
    }

    @Override
    public UserDto getUserById(Long userId) {
        User savedUser = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException(User.class.getSimpleName(), "id", userId));
//        return UserMapper.mapToUserDto(savedUser);
        return UserMapperStruct.MAPPER.userToUserDto(savedUser);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
//        List<UserDto> userDtoList = users.stream().map(UserMapper::mapToUserDto).toList();
        List<UserDto> userDtoList = users.stream().map(UserMapperStruct.MAPPER::userToUserDto).toList();
        return userDtoList;
    }

    @Override
    public UserDto updateUser(Long userId, UserDto userDto) {
        Optional<User> userObject = userRepository.findById(userId);
        User existingUser = userObject.orElseThrow(() -> new ResourceNotFoundException(User.class.getSimpleName(), "id", userId));
        existingUser.setFirstName(userDto.getFname());
        existingUser.setLastName(userDto.getLname());
        if (!userDto.getEmail().isBlank()) {
            existingUser.setEmail(userDto.getEmail());
        }
        User tempUser = userRepository.save(existingUser);
        return UserMapper.mapToUserDto(tempUser);
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException(User.class.getSimpleName(), "id", userId));
        userRepository.deleteById(userId);
    }
}
