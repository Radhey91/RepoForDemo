package com.codewithdurgesh.blog.blogappapis.payloadsDto;


import lombok.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor


public class PostDto
{
    @Autowired
    private ModelMapper modelMapper;

//   private String userId;
    private String title;
    private String content;
    private String imageName;
    private Date addedDate;
    private CategoryDto category;
    private UserDto user;

}
