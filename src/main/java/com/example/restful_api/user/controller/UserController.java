package com.example.restful_api.user.controller;

import com.example.restful_api.user.dto.UserCreateRequest;
import com.example.restful_api.user.dto.UserResponse;
import com.example.restful_api.user.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @DeleteMapping("{id}")
    public void deleteById(@PathVariable Long id){
        userService.delete(id);
    }
    @GetMapping
    public List<UserResponse> getAll(){
        return userService.getAll();
    }

    @GetMapping("{id}")
    public UserResponse getById(@PathVariable Long id){
        return userService.getById(id);
    }

    @PostMapping
    public UserResponse create(@RequestBody UserCreateRequest request){
        return userService.create(request);
    }

    @PutMapping("{id}")
    public UserResponse update(@PathVariable Long id, @RequestBody UserCreateRequest request){
        return userService.update(id,request);
    }
}
