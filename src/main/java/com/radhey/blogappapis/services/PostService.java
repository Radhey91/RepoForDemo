package com.radhey.blogappapis.services;

import com.radhey.blogappapis.entities.Post;
import com.radhey.blogappapis.payloads.PostDto;
import com.radhey.blogappapis.payloads.PostResponse;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.List;

public interface PostService
{
    PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);

    PostDto updatePost(PostDto postDto, Integer postId);

    void deletePost(Integer postId);

    PostResponse getAllPost(Integer pageNumber, Integer pageSize, String sortBy);

    PostDto getByPostId(Integer postId);

    List<PostDto> getPostByCategory(Integer categoryId);

    List<PostDto> getPostByUser(Integer userId);
    List<PostDto> searchPost(String keyword);

}
