package com.example.music.service.impl;

import com.example.music.exception.TrackNotFoundException;
import com.example.music.exception.UserNotFoundException;
import com.example.music.model.User;
import com.example.music.repository.UserRepository;
import com.example.music.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserById(UUID id) {

        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    @Override
    public User updateUser(UUID id, User user) {

        if(!userRepository.existsById(id)) {
            throw new TrackNotFoundException(id);
        }

        user.setId(id);

        return userRepository.save(user);
    }

    @Override
    public void deleteUserById(UUID id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
