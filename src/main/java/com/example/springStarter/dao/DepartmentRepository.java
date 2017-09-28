package com.example.springStarter.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.springStarter.model.Department;

@Repository
public interface DepartmentRepository  extends CrudRepository<Department, Integer> {
	
	

}
