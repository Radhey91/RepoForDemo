package com.codewithdurgesh.blog.blogappapis.payloadsDto;

import lombok.Data;

import javax.validation.constraints.*;

@Data
public class UserDto
{
    private int id;
    @NotEmpty
    @Size(min = 4, message="Username must be min of 4 charectors !!")
    private String name;
    @Email(message = " Email address is not valid")
    private String email;
    @NotEmpty
    @Size(min=3, max=10, message= "Password must be min of 3 char and max of 10 char !! ")
    private String password;
    @NotNull
    private String about;
}
