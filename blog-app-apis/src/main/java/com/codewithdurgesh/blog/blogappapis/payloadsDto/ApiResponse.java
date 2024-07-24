package com.codewithdurgesh.blog.blogappapis.payloadsDto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse
{
    private String message;
    private boolean success;

}
