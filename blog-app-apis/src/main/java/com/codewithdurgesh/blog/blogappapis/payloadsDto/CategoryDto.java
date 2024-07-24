package com.codewithdurgesh.blog.blogappapis.payloadsDto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class CategoryDto
{
    private Integer categoryId;
    @NotBlank
    @Size(min=3, max = 20)
    private String  categoryTitle;
    @NotBlank
    @Size(min= 10, max= 200)
    private String categoryDescription;
}
