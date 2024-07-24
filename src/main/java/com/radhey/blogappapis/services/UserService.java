package com.radhey.blogappapis.services;

import com.radhey.blogappapis.entities.User;
import com.radhey.blogappapis.payloads.UserDto;

import java.util.List;

public interface UserService {

    UserDto createUser(UserDto user);
    UserDto updateUser(UserDto userDto, Integer userId);
    UserDto getUserById(Integer userId);
    List<UserDto> getAll();
    void deleteUser(Integer userId);

}
