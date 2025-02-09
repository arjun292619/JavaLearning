package net.javaguides.spring_user_rest_service.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import net.javaguides.spring_user_rest_service.dto.UserDto;
import net.javaguides.spring_user_rest_service.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/users")
@Tag(name = "CRUD REST Apis for User Resource",
        description = "Create User, Get User, Get all Users, Update User and Delete User")
public class UserController {
    private UserService userService;

    //    build create User REST Api
    @Operation(summary = "Create User REST Api", responses = @ApiResponse(responseCode = "201",
            description = "HTTP Status 201 created"))
    @PostMapping
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto user) {
        if (user.getEmail().isBlank()) {
            user.setEmail(user.getFname().charAt(0) + user.getLname() + "@email.com");
        }
        UserDto savedUser = userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }

    //    build get User REST Api
    @Operation(summary = "Get User by id REST Api", responses = {@ApiResponse(responseCode = "200",
            description = "HTTP Status 200 ok"),@ApiResponse(responseCode = "400",
            description = "HTTP Status 400 Bad Request. id parameter wrong")})
    @GetMapping("{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("id") Long userId) {
        UserDto userDto = userService.getUserById(userId);
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

    //    build get all Users REST Api
    @GetMapping()
    @Operation(summary = "Get all Users REST Api", responses = @ApiResponse(responseCode = "200",
            description = "HTTP Status 200 ok"))
    @PostMapping
    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<UserDto> userDtos = userService.getAllUsers();
        return new ResponseEntity<>(userDtos, HttpStatus.OK);
    }

    //    build update User REST Api
    @PutMapping("{id}")
    @Operation(summary = "Update User by id REST Api", responses = {@ApiResponse(responseCode = "200",
            description = "HTTP Status 202 ok"),@ApiResponse(responseCode = "400",
            description = "HTTP Status 400 Bad Request. id parameter wrong")})
    public ResponseEntity<UserDto> updateUser(@Valid @PathVariable("id") Long userId, @RequestBody UserDto userDto) {
        UserDto updatedUserObject = userService.updateUser(userId, userDto);
        return ResponseEntity.status(HttpStatus.OK).body(updatedUserObject);
    }

    //    build delete User REST Api
    @DeleteMapping("{id}")
    @Operation(summary = "Delete User by id REST Api", responses = {@ApiResponse(responseCode = "200",
            description = "HTTP Status 200 ok"),@ApiResponse(responseCode = "400",
            description = "HTTP Status 400 Bad Request. id parameter wrong")})
    public ResponseEntity<String> deleteUserById(@PathVariable("id") Long userId) {
        userService.deleteUser(userId);
        return new ResponseEntity<String>("User deleted successfully", HttpStatus.OK);
    }
}
