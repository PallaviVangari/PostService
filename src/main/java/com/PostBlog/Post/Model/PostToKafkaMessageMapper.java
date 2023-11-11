package com.PostBlog.Post.Model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class PostToKafkaMessageMapper {

	public String writeValueAsJson(Post post, String eventType) throws JsonProcessingException
	{
		KafkaMessage message = new KafkaMessage();
		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new JavaTimeModule());
	    mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
	    
		switch(eventType)
		{
			case "tweet_created":
								 mapPostToKafkaMessage(post,message,eventType);
								 return mapper.writeValueAsString(message);
			case "tweet_updated":
								 mapPostToKafkaMessage(post,message,eventType);
								 return mapper.writeValueAsString(message);
			case "tweet_deleted":
								 mapPostToKafkaMessage(post,message,eventType);
								 return mapper.writeValueAsString(message);
							
		}
		return null;
	}
	private void mapPostToKafkaMessage(Post post, KafkaMessage message, String eventType)
	{
		message.setEvent_type(eventType);
		message.setContent(post.getContent());
		 message.setCreatedDate(post.getCreatedDate());
		 message.setPostId(post.getPostId());
		 message.setLastModifiedDate(post.getLastModifiedDate());
		 message.setUserId(post.getuserId());
		 message.setAuthorId(post.getAuthorId());
	}
}
