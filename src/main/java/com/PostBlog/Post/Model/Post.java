package com.PostBlog.Post.Model;
import java.time.Instant;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "PostsDB")
public class Post {

	@Id
	private String postId;
	
	private String userId;
	
	private String authorId;

	@CreatedDate
    private Instant createdDate;

    @LastModifiedDate
    private Instant lastModifiedDate;
	
	private String content;

	public String getPostId()
	{
		return postId;
	}
	public String getuserId()
	{
		return userId;
	}
	public void setUserId(String val)
	{
		userId = val;
	}
	public String getContent()
	{
		return content;
	}
	public void setContent(String content)
	{
		this.content = content;
	}
	public Instant getCreatedDate() {
        return createdDate;
    }

    public Instant getLastModifiedDate() {
        return lastModifiedDate;
    }

	public String getAuthorId() {
		return authorId;
	}
	
	public void setAuthorId(String authorId) {
		this.authorId = authorId;
	}
}
