package com.example.springStarter.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.springStarter.model.ClassOrder;
import com.example.springStarter.model.Course;
import com.example.springStarter.model.Order;
import com.example.springStarter.model.Textbook;

@Repository
public interface ClassorderRepository  extends CrudRepository<ClassOrder, Integer> {

	List<ClassOrder> findAllByCourseAndOrderAndTextbook(Course course, Order order,Textbook textbook);

}
