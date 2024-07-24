package com.codewithdurgesh.blog.blogappapis.repositories;

import com.codewithdurgesh.blog.blogappapis.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category,Integer> {
}
