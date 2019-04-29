package io.sanchit.springbootstarter.topic;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	@Autowired
	private TopicRepository topicReposiroty;
	
	public List<Topic> getAllTopics(){
		List<Topic> topics = new ArrayList<Topic>();
		topicReposiroty.findAll().forEach(topics::add);
		return topics;
	}
	
	public Topic getTopic(String id) {
		return topicReposiroty.findById(id).orElse(null);
	}
	
	public void addTopic(Topic t) {
		topicReposiroty.save(t);
	}

	public void updateTopic(Topic topic) {
		topicReposiroty.save(topic);
	}

	public void deleteTopic(String id) {
		topicReposiroty.deleteById(id);;
	}
}
