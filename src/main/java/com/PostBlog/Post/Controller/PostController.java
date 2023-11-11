package com.PostBlog.Post.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.PostBlog.Post.Model.Post;
import com.PostBlog.Post.Service.KafkaProducerService;
import com.PostBlog.Post.Service.PostService;
import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
@RequestMapping("/api/post")
public class PostController {

	@Autowired
	private PostService postService;
	
	@Autowired
	private KafkaProducerService kafkaProducerService;
	
	@PostMapping("/createPost")
	public void addPost(@RequestBody Post post) throws JsonProcessingException
	{
		postService.addPost(post);
		kafkaProducerService.sendMessage(post,"tweet_created");
	}
	
	//@GetMapping
	//public List<Post> getAllPosts()
	//{
	//	return postService.getPosts();
	//}
	
	@GetMapping("/getUserPosts/{userId}")
	public List<Post> getAllPostsByUserId(@PathVariable String userId)
	{
		return postService.getPostsByUserId(userId);
	}
	
	@PutMapping("/updatePost/{userId}/{postId}")
	public Optional<Post> updatePostById(@PathVariable String userId, @PathVariable String postId, @RequestBody Post post) throws JsonProcessingException
	{
		var updatedPost = postService.updatePostByPostId(userId, postId, post);
		if(updatedPost.isPresent())
		{
			var postUpdated = updatedPost.get();
			kafkaProducerService.sendMessage(postUpdated,"tweet_updated");
		}
		return updatedPost;
	}
	
	@DeleteMapping("/deletePost/{userId}/{postId}")
	public void deletePostByPostId(@PathVariable String userId, @PathVariable String postId) throws JsonProcessingException
	{
		var post = postService.getPostByPostId(postId);
		var isPostDeleted = postService.deletePostByPostId(userId, postId);
		if(post.isPresent() && isPostDeleted)
		{
			var postDeleted = post.get();
			kafkaProducerService.sendMessage(postDeleted,"tweet_deleted");
		}
	}
}
