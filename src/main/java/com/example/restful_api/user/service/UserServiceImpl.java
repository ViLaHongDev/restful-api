package com.example.restful_api.user.service;

import com.example.restful_api.user.dto.UserCreateRequest;
import com.example.restful_api.user.dto.UserResponse;
import com.example.restful_api.user.entity.User;
import com.example.restful_api.user.mapper.UserMapper;
import com.example.restful_api.user.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UserResponse create(UserCreateRequest request) {
        User user = new User();
        user.setUserName(request.getUserName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());

        User saved = userRepository.save(user);

        return userMapper.toResponse(saved);
    }

    @Override
    public List<UserResponse> getAll() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(userMapper::toResponse)
                .toList();
    }

    @Override
    public UserResponse getById(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()){
            throw new RuntimeException("User not found");
        }
        return userMapper.toResponse(user.get());
    }
}
