package com.example.springStarter.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.example.springStarter.model.Department;
import com.example.springStarter.model.User;

@Repository
@Component
public interface UserRepository  extends CrudRepository<User, Integer> {



	List<User> findAllByEmailidIgnoreCase(String emailid);
	List<User> findAllByDepartmentAndRole(Department department,String role);

}
