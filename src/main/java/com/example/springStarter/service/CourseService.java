package com.example.springStarter.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.springStarter.dao.CourseRepository;
import com.example.springStarter.model.Course;



@Service
@Transactional
public class CourseService {



		private final CourseRepository courseRepository;


		public CourseService(CourseRepository courseRepository){
			this.courseRepository=courseRepository;
		}

		public List<Course> findAll(){
			List<Course> courses = new ArrayList<>();

			for(Course course: courseRepository.findAll()){
				courses.add(course);
			}
			return courses;
		}

		public void save(Course course){
			courseRepository.save(course);
		}

		public void delete(int id){
			courseRepository.delete(id);
		}

		public Course findCourseById(int id){
			return courseRepository.findOne(id);
		}





}
