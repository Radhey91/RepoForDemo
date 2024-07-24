package com.radhey.blogappapis.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class UserDto {

    private int id;
    @NotEmpty
    @Size(min = 4, message ="Username must be min of 4 characters !!")
    private String name;
    @Email(message = "Email address is not valid")
    private String email;
    @NotEmpty(message = "Password must be min of 3 and max of 10 characters")
    @Size(min = 3,max = 10)
    private String password;
    @NotNull
    private String about;
}
