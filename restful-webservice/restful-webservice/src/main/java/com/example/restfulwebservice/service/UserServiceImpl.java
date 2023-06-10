package com.example.restfulwebservice.service;

import com.example.restfulwebservice.dto.UserDto;
import com.example.restfulwebservice.entity.User;
//import com.example.restfulwebservice.exception.EmailAlreadyExistException;
import com.example.restfulwebservice.exception.ResourceNotFoundException;
import com.example.restfulwebservice.mapper.UserMapper;
import com.example.restfulwebservice.mapper.UserMapperUsingMapstruct;
import com.example.restfulwebservice.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{

    private UserRepository repo;

    private ModelMapper modelMapper;

    @Override
    public UserDto createUser(UserDto userDto) {
        //convert userdto to user jpa entity
//        User user = UserMapper.mapUserDtoToUser(userDto);

        Optional<User> getEmailFromDb = repo.findByEmail(userDto.getEmail());
//        if(getEmailFromDb.isPresent()){
//            throw new EmailAlreadyExistException("Email already exist for the User!!");
//        }

        User user = UserMapperUsingMapstruct.MAPPER.mapUserDtoToUser(userDto);
        User savedUser = repo.save(user);
        //convert user jpa entity to user dto
//        UserDto savedUserDto = UserMapper.mapUserToUserDto(savedUser);
//        UserDto savedUserDto = modelMapper.map(savedUser,UserDto.class);
        UserDto savedUserDto = UserMapperUsingMapstruct.MAPPER.mapUserToUserDto(savedUser);
        return savedUserDto;
    }

    @Override
    public UserDto getUserById(Long userId) {

        User user = repo.findById(userId).orElseThrow(
                ()-> new ResourceNotFoundException("User","id",userId)
        );
//        User user = getUserUsingId.get();
//        UserDto userDto = modelMapper.map(user,UserDto.class);
        return UserMapperUsingMapstruct.MAPPER.mapUserToUserDto(user);
    }


    @Override
    public List<UserDto> getAllUser() {
       List<User> users =  repo.findAll();
//        return users.stream().map(UserMapper::mapUserToUserDto).collect(Collectors.toList());
//        return users.stream().map(user -> modelMapper.map(users,UserDto.class)).collect(Collectors.toList());
        return users.stream().map(user -> UserMapperUsingMapstruct.MAPPER.mapUserToUserDto(user))
                .collect(Collectors.toList());
    }

    @Override
    public UserDto updateUser(UserDto user) {
        User existingUser = repo.findById(user.getId()).orElseThrow(
                ()-> new ResourceNotFoundException("User","id",user.getId())
        );
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());
        User updateUser = repo.save(existingUser);
//        return UserMapper.mapUserToUserDto(updateUser);
//        return modelMapper.map(updateUser,UserDto.class);
        return UserMapperUsingMapstruct.MAPPER.mapUserToUserDto(updateUser);
    }

    @Override
    public ResponseEntity<Object> deleteUserById(Long userId) {
        User existingUser = repo.findById(userId).orElseThrow(
                ()-> new ResourceNotFoundException("User","id",userId)
        );
        repo.deleteById(userId);
        return ResponseEntity.ok().body("User has been deleted successfully!!!!");
    }
}
