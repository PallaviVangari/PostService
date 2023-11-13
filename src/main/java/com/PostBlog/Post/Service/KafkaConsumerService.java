package com.PostBlog.Post.Service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class KafkaConsumerService {
	
	ObjectMapper mapper = new ObjectMapper();
    
    @KafkaListener(topics = "my-topic", groupId = "my-group")
    
    public void receiveMessage(String message) {

    	System.out.println("Receive Message: "+message);
    }
}