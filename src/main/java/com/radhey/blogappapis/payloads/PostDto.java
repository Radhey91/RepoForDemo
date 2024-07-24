package com.radhey.blogappapis.payloads;

import com.radhey.blogappapis.entities.Category;
import com.radhey.blogappapis.entities.User;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter@NoArgsConstructor
public class PostDto {

    private Integer postId;

    private String title;
    private String content;
    private String imageName;
    private Date addedDate;

    private CategoryDto category;

    private UserDto user;

}
