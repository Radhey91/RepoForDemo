package com.radhey.blogappapis.serviceimpl;

import com.radhey.blogappapis.entities.Category;
import com.radhey.blogappapis.entities.Post;
import com.radhey.blogappapis.entities.User;
import com.radhey.blogappapis.exceptions.ResourceNotFoundException;
import com.radhey.blogappapis.payloads.PostDto;
import com.radhey.blogappapis.payloads.PostResponse;
import com.radhey.blogappapis.repository.CategoryRepo;
import com.radhey.blogappapis.repository.PostRepo;
import com.radhey.blogappapis.repository.UserRepo;
import com.radhey.blogappapis.services.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepo postRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private CategoryRepo categoryRepo;

    @Override
    public PostDto createPost(PostDto postDto, Integer userId, Integer categoryId) {

        User user =this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User", "user id", userId));
        Category category = this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category","category id",categoryId));

        Post post= this.modelMapper.map(postDto, Post.class);
        post.setImageName("default.png");
        post.setAddedDate(new Date());
        post.setUser(user);
        post.setCategory(category);

        Post newPost= this.postRepo.save(post);

        return this.modelMapper.map(newPost,PostDto.class);
    }

    @Override
    public PostDto updatePost(PostDto postDto, Integer postId) {

        Post post = this.postRepo.findById(postId).orElseThrow(()->new ResourceNotFoundException("Post", "post id",postId));

        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
        post.setImageName(postDto.getImageName());

        Post updatedPost = this.postRepo.save(post);

        return this.modelMapper.map(updatedPost,PostDto.class);
    }

    @Override
    public void deletePost(Integer postId) {
        Post post = this.postRepo.findById(postId).orElseThrow(()-> new ResourceNotFoundException("Post","post id", postId));
        this.postRepo.delete(post);
    }

    @Override
    public PostResponse getAllPost(Integer pageNumber, Integer pageSize, String sortBy) {

//        Pageable p = PageRequest.of(pageNumber, pageSize);
//        Page<Post> pagePost = this.postRepo.findAll(p);
//        List<Post> getAll= pagePost.getContent();
//
//        List<PostDto> posts = getAll.stream().map((post)-> this.modelMapper
//                .map(post, PostDto.class)).collect(Collectors.toList());
//
//        return posts;
//    }

        try {
            Pageable paging = PageRequest.of(pageNumber, pageSize, Sort.by(sortBy));
            Page<Post> pagePosts = postRepo.findAll(paging);
            List<Post> posts = pagePosts.getContent();
            List<PostDto> p= posts.stream()
                    .map(post -> modelMapper.map(post, PostDto.class))
                    .collect(Collectors.toList());

            PostResponse postResponse = new PostResponse();
            postResponse.setContent(p);
            postResponse.setPageNumber(pagePosts.getNumber());
            postResponse.setPageSize(pagePosts.getSize());
            postResponse.setTotalElements(pagePosts.getTotalElements());
            postResponse.setTotalPage(pagePosts.getTotalPages());
            postResponse.setLastPage(pagePosts.isLast());

            return postResponse;
        } catch (Exception e) {
            e.printStackTrace();
            return new PostResponse(); // Return an empty list or handle differently as needed
        }
    }

    @Override
    public PostDto getByPostId(Integer postId) {
        Post post = this.postRepo.findById(postId).orElseThrow(()-> new ResourceNotFoundException("Post", "post id", postId));

        return this.modelMapper.map(post, PostDto.class);
    }

    @Override
    public List<PostDto> getPostByCategory(Integer categoryId) {

        Category cat = this.categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category","category id",categoryId));
        List<Post> posts= this.postRepo.findByCategory(cat);
        List<PostDto> postDtos = posts.stream().map((post) -> this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());

        return postDtos;
    }

    @Override
    public List<PostDto> getPostByUser(Integer userId) {

        User user = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "user id", userId));
        List<Post> users = this.postRepo.findByUser(user);
        List<PostDto> postDtos = users.stream().map((post)-> this.modelMapper.map(user, PostDto.class)).collect(Collectors.toList());

        return postDtos;
    }

    @Override
    public List<PostDto> searchPost(String keyword) {

        List<Post> posts = this.postRepo.findByTitleContaining(keyword);
        List<PostDto> postDtos = posts.stream().map((post) -> this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());

        return postDtos;
    }
}
