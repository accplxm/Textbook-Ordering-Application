package com.example.springStarter.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.springStarter.model.Course;

@Repository
public interface CourseRepository  extends CrudRepository<Course, Integer> {



}
