package com.example.springStarter.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.springStarter.model.Course;

@Repository
public interface CourseRepository  extends CrudRepository<Course, Integer> {



//	@Query("SELECT c FROM order_table o INNER JOIN o..department d INNER JOIN u.department d where d.department_id = ?1 and o.status = ?2")
//	List<Order> findUserByDepartmentAndUserRole(int departmentId,String role);

	@Query("SELECT cs FROM order_table o INNER JOIN o.term t INNER JOIN o.classOrders co INNER JOIN co.course cs INNER JOIN cs.department d Where d.department_id = ?1 and t.term_id= ?2 and o.status=?3")
	List<Course> findCoursesByDepartmentAndTermAndOrderStatus(int departmentId,int  termId,String orderStatus);


	@Query("SELECT cs FROM order_table o INNER JOIN o.term t INNER JOIN o.classOrders co INNER JOIN co.course cs INNER JOIN cs.department d Where d.department_id = ?1 and t.term_id= ?2")
	List<Course> findCoursesByDepartmentAndTerm(int departmentId,int  termId);

	@Query("SELECT cs,o FROM order_table o INNER JOIN o.term t INNER JOIN o.classOrders co INNER JOIN co.course cs INNER JOIN cs.department d Where d.department_id = ?1 and t.term_id= ?2 and o.status=?3")
	List<Object> findCoursesAndOrdersByDepartmentAndTerm(int departmentId,int  termId,String orderStatus);

}
