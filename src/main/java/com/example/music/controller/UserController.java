package com.example.music.controller;

import com.example.music.dto.request.UserRequest;
import com.example.music.dto.request.UserRequest;
import com.example.music.dto.response.UserResponse;
import com.example.music.dto.response.UserResponse;
import com.example.music.mapper.UserMapper;
import com.example.music.mapper.UserMapper;
import com.example.music.service.UserService;
import com.example.music.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static com.example.music.constants.EndpointConstants.URL_USER_API;

@RestController
@RequiredArgsConstructor
@RequestMapping(URL_USER_API)
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    @PostMapping
    private UserResponse createUser(@RequestBody UserRequest userRequest) {
        return userMapper.toResponse(userService.createUser(userMapper.toUser(userRequest)));
    }

    @GetMapping("{id}")
    private UserResponse getUser(@PathVariable UUID id) {
        return userMapper.toResponse(userService.getUserById(id));
    }

    @GetMapping
    private List<UserResponse> getUsers() {
        return userService.getAllUsers().stream().map(userMapper::toResponse).toList();
    }

    @PutMapping("{id}")
    private UserResponse updateUser(@PathVariable UUID id, @RequestBody UserRequest UserRequest) {
        return userMapper.toResponse(userService.updateUser(id, userMapper.toUser(UserRequest)));
    }

    @DeleteMapping("{id}")
    private void deleteUser(@PathVariable UUID id) {
        userService.deleteUserById(id);
    }
}
