package com.example.restful_api.user.service;

import com.example.restful_api.user.dto.UserCreateRequest;
import com.example.restful_api.user.dto.UserResponse;

import java.util.List;

public interface UserService {
    public UserResponse create(UserCreateRequest request);
    public List<UserResponse> getAll();
    public UserResponse getById(Long id);
    public void delete(Long id);
    public UserResponse update(Long id,UserCreateRequest request);
}
