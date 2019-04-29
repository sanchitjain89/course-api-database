package io.sanchit.springbootstarter.course;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepository courseReposiroty;
	
	public List<Course> getAllCourses(String topicId){
		List<Course> courses = new ArrayList<Course>();
		courseReposiroty.findByTopicId(topicId).forEach(courses::add);
		return courses;
	}
	
	public Course getCourse(String id) {
		return courseReposiroty.findById(id).orElse(null);
	}
	
	public void addCourse(Course t) {
		courseReposiroty.save(t);
	}

	public void updateCourse(Course course) {
		courseReposiroty.save(course);
	}

	public void deleteCourse(String id) {
		courseReposiroty.deleteById(id);;
	}
}
