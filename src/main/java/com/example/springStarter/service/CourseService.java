package com.example.springStarter.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.springStarter.dao.CourseRepository;
import com.example.springStarter.model.Course;
import com.example.springStarter.model.Department;



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

		public Course save(Course course){
			return courseRepository.save(course);
		}

		public void delete(int id){
			courseRepository.delete(id);
		}

		public Course findCourseById(int id){
			return courseRepository.findOne(id);
		}


		public List<Course> findCoursesByDepartmentAndTermAndOrderStatus(int departmentId,int  termId,String orderStatus){
			return courseRepository.findCoursesByDepartmentAndTermAndOrderStatus(departmentId, termId,orderStatus);
		}

		public List<Object> findCoursesAndOrderByDepartmentAndTerm(int departmentId,int  termId,String orderStatus){
			return courseRepository.findCoursesAndOrdersByDepartmentAndTerm(departmentId, termId, orderStatus);
		}

		public List<Course> findCoursesByDepartmentAndTerm(int departmentId,int  termId){
		return courseRepository.findCoursesByDepartmentAndTerm(departmentId, termId);
}

		public List<Course> findAllByDepartment(Department departmentId){
			return courseRepository.findAllByDepartment(departmentId);
	}


}
