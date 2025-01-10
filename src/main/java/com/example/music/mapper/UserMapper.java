package com.example.music.mapper;

import com.example.music.dto.request.UserRequest;
import com.example.music.dto.response.UserResponse;
import com.example.music.model.User;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface UserMapper {

    UserResponse toResponse(User user);

    User toUser(UserRequest userRequest);
}
