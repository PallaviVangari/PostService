package com.PostBlog.Post.Model;

import java.time.LocalDateTime;

public class KafkaMessage {

	private String eventType;
	
	private String userId;
	
	private String tweetId;
	
	private String authorId;
	
	private String content;
	
	private LocalDateTime timestamp;
	
	private LocalDateTime timestampUpdated;
	

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getTweetId() {
		return tweetId;
	}

	public void setTweetId(String tweetId) {
		this.tweetId = tweetId;
	}

	public String getAuthorId() {
		return authorId;
	}

	public void setAuthorId(String authorId) {
		this.authorId = authorId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public LocalDateTime getTimestampUpdated() {
		return timestampUpdated;
	}

	public void setTimestampUpdated(LocalDateTime timestampUpdated) {
		this.timestampUpdated = timestampUpdated;
	}

}
