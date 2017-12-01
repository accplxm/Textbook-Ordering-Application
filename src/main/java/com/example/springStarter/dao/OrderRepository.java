package com.example.springStarter.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.springStarter.model.Order;
import com.example.springStarter.model.Term;
import com.example.springStarter.model.User;

@Repository
public interface OrderRepository  extends CrudRepository<Order, Integer> {

	List<Order> findAllByuser(User user);

	//@Query("SELECT o FROM user u inner join department d on d.department_id = u.department_id inner join order o on o.user_id = u.user_id where d.department_id = ?1;")

	@Query("SELECT o FROM order_table o INNER JOIN o.user u INNER JOIN u.department d where d.department_id = ?1 and o.status = ?2")
	List<Order> findUserByDepartmentAndUserRole(int departmentId,String role);


	@Query("SELECT o FROM order_table o INNER JOIN o.user u INNER JOIN u.department d where d.department_id = ?1 and u.user_id = ?2 and o.term= ?3")
	List<Order> findOrderByDepartmentAndTermAndUser(int departmentId,int userId,Term termId);

	List<Order> findAllByTerm(Term term);
}
