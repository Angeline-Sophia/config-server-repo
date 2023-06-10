package com.example.restfulwebservice.service;

import com.example.restfulwebservice.dto.UserDto;
import com.example.restfulwebservice.entity.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {

    UserDto createUser(UserDto user);

    UserDto getUserById(Long userId);

    List<UserDto> getAllUser();

    UserDto updateUser(UserDto user);

    ResponseEntity<Object> deleteUserById(Long userId);
}
