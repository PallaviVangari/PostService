package com.PostBlog.Post.dao;

import com.PostBlog.Post.Model.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface IPostDao extends MongoRepository<Post, String> {

    // The standard CRUD operations like save, findById, deleteById, etc., are inherited from MongoRepository

    // Custom method to retrieve all posts by a specific user
    List<Post> findByUserId(String userId);

    // Custom method to add a Post (not necessary if using the save method)
    // Post addPost(Post post);

    // Custom method to update a Post by id (not necessary if using the save method)
    // Post updatePostById(Long postId, Post post);

    // Additional custom methods can be defined here
}
