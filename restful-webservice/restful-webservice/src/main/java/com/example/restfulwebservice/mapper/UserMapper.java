package com.example.restfulwebservice.mapper;

import com.example.restfulwebservice.dto.UserDto;
import com.example.restfulwebservice.entity.User;

public class UserMapper {

    //convert UserDto to User JPA entity
    public static UserDto mapUserToUserDto(User user){
        UserDto userDto = new UserDto(user.getId(), user.getFirstName(), user.getLastName(), user.getEmail());
        return userDto;
    }
    //convert User JPA entity to UserDto
    public static User mapUserDtoToUser(UserDto userDto){
        User user = new User(userDto.getId(), userDto.getFirstName(), userDto.getLastName(), userDto.getEmail());
        return user;
    }
}
