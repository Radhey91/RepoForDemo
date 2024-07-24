package com.radhey.blogappapis.repository;

import com.radhey.blogappapis.entities.Category;
import com.radhey.blogappapis.entities.Post;
import com.radhey.blogappapis.entities.User;
import com.radhey.blogappapis.payloads.PostDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepo extends JpaRepository<Post, Integer> {

    List<Post> findByUser(User user);
    List<Post> findByCategory(Category category);

    List<Post> findByTitleContaining (String title);

}
