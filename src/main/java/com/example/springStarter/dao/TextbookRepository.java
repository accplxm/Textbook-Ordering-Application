package com.example.springStarter.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.springStarter.model.Department;
import com.example.springStarter.model.Textbook;
import com.example.springStarter.model.User;

@Repository
public interface TextbookRepository  extends CrudRepository<Textbook, Integer> {



	@Query("SELECT t FROM textbook t INNER JOIN t.classOrders co INNER JOIN co.course cs INNER JOIN co.order o INNER JOIN o.term tm where tm.term_id = ?1 and cs.class_id = ?2 and o.order_id=?3")
	List<Textbook> findTextbooksByTermAndCourse(int termId,int courseId,int orderId);


	List<Textbook> findAllByTitleAndAuthorAndCopyrightAndEditionAndIsbnAndPublisher(String title, String author,String copyright, String edition,String isbn,String publisher);
}
