package com.PostBlog.Post.Model;

import java.time.Instant;

public class KafkaMessage {

	private String eventType;
	
	private String userId;
	
	private String tweetId;
	
	private String authorId;
	
	private String content;
	
	private Instant timestamp;
	
	private Instant timestampUpdated;
	

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

	public Instant getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Instant timestamp) {
		this.timestamp = timestamp;
	}

	public Instant getTimestampUpdated() {
		return timestampUpdated;
	}

	public void setTimestampUpdated(Instant timestampUpdated) {
		this.timestampUpdated = timestampUpdated;
	}

}
