package com.codewithdurgesh.blog.blogappapis.controllers;

import com.codewithdurgesh.blog.blogappapis.payloadsDto.ApiResponse;
import com.codewithdurgesh.blog.blogappapis.payloadsDto.UserDto;
import com.codewithdurgesh.blog.blogappapis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    // Create New User in database-----------------------------
    @PostMapping("/userCreation")
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto)
    {
        UserDto creteUserDto = this.userService.createUser(userDto);
        return new ResponseEntity<>(creteUserDto, HttpStatus.CREATED);
    }

    // update existing User from database----------------------
    @PutMapping("/{userId}")
    public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto, @PathVariable("userId") Integer userid)
    {
        UserDto updateUser = this.userService.updateUser(userDto ,userid);
        return ResponseEntity.ok(updateUser);
    }

    // Delete User from Database -------------------------------
    @DeleteMapping("/{userId}")
    public ResponseEntity<ApiResponse> deleteUser (@PathVariable("userId") Integer userid)
    {
        this.userService.deleteUser(userid);
        return new ResponseEntity<ApiResponse>(new ApiResponse("User delete successfully",true), HttpStatus.ACCEPTED);
    }

    // Get All User from database-------------------------------
    @GetMapping("/")
    public ResponseEntity<List<UserDto>> getAllUsers( )
    {
        return ResponseEntity.ok(this.userService.getAllUsers());
    }

    // Get User By Id from Database------------------------------
    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Integer userId)
    {
        return ResponseEntity.ok(this.userService.getById(userId));
    }

}
