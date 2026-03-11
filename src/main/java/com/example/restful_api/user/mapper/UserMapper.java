    package com.example.restful_api.user.mapper;

    import com.example.restful_api.user.dto.UserResponse;
    import com.example.restful_api.user.entity.User;
    import org.springframework.stereotype.Component;

    @Component
    public class UserMapper {
        public UserResponse toResponse(User user){
            UserResponse userResponse = new UserResponse();
            userResponse.setUserName(user.getUserName());
            userResponse.setEmail(user.getEmail());
            userResponse.setPassword(user.getPassword());
            return userResponse;
        }
    }
