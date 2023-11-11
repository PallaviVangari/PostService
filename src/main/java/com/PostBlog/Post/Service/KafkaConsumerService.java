package com.PostBlog.Post.Service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.PostBlog.Post.Model.Post;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@Component
public class KafkaConsumerService {
	
	ObjectMapper mapper = new ObjectMapper();
    
    @KafkaListener(topics = "my-topic", groupId = "my-group")
    
    public void receiveMessage(String message) throws JsonMappingException, JsonProcessingException {
        // Process the received message

    	mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    	mapper.registerModule(new JavaTimeModule());
    	
    	var obj = mapper.readValue(message,Post.class);
    	JsonNode rootNode = mapper.readTree(message); 
    	if (rootNode.has("event_type")) {
    	    var eventType = rootNode.get("event_type").asText();
    	    System.out.println("Event type:"+eventType);
    	}
    	
        System.out.println("Received message:\n Content : "+obj.getContent());
        System.out.println("CreatedDate: "+obj.getCreatedDate());
        System.out.println("LastModifiedDate: "+obj.getLastModifiedDate());
        System.out.println("Post Id: "+obj.getPostId());
        System.out.println("User Id: "+obj.getuserId());
        System.out.println("Author Id: "+obj.getAuthorId());
    }
}