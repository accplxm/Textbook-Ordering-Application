package com.example.springStarter.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.springStarter.model.Task;



public interface TaskRepository extends CrudRepository<Task, Integer> {

	
	
}




