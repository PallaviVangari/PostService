package com.PostBlog.Post.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.PostBlog.Post.Model.Post;
import com.PostBlog.Post.Model.PostToKafkaMessageMapper;
import com.fasterxml.jackson.core.JsonProcessingException;

@Service
public class KafkaProducerService {
    private final KafkaTemplate<String, String> kafkaTemplate;
    PostToKafkaMessageMapper mapper = new PostToKafkaMessageMapper();
    
    @Autowired
    public KafkaProducerService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(Post post, String eventType) {
    	
    	String json = null;
		try {
			json = mapper.writeValueAsJson(post, eventType);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			System.out.println("Faced an exception while processing json");
			e.printStackTrace();
		}
        kafkaTemplate.send("my-topic", json);
    }
}