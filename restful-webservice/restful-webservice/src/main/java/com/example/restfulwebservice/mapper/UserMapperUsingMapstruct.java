package com.example.restfulwebservice.mapper;

import com.example.restfulwebservice.dto.UserDto;
import com.example.restfulwebservice.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapperUsingMapstruct {

    //Provide implementation class at complitation time,
    // using mappers utility class to call these mapping method

    UserMapperUsingMapstruct MAPPER = Mappers.getMapper(UserMapperUsingMapstruct.class);

//    @Mapping(source = "UserFirstName",target = "firstName")
//    @Mapping(source = "UserLastName",target = "lastName")
    UserDto mapUserToUserDto(User user);

    User mapUserDtoToUser(UserDto userDto);
}
