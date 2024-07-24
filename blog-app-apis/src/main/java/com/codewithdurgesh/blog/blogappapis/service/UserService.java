package com.codewithdurgesh.blog.blogappapis.service;

import com.codewithdurgesh.blog.blogappapis.payloadsDto.UserDto;

import java.util.List;

public interface UserService
{
    UserDto createUser(UserDto user);
    UserDto updateUser(UserDto user, Integer userId);
    UserDto getById(Integer userId);
    List<UserDto> getAllUsers();
    void deleteUser(Integer userId);
}
