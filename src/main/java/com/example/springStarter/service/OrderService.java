package com.example.springStarter.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.springStarter.dao.OrderRepository;
import com.example.springStarter.model.Order;
import com.example.springStarter.model.Term;
import com.example.springStarter.model.User;



@Service
@Transactional
public class OrderService {



		private final OrderRepository orderRepository;


		public OrderService(OrderRepository orderRepository){
			this.orderRepository=orderRepository;
		}

		public List<Order> findAll(){
			List<Order> orders = new ArrayList<>();

			for(Order order: orderRepository.findAll()){
				orders.add(order);
			}
			return orders;
		}

		public Order save(Order order){
			return orderRepository.save(order);
		}

		public void delete(int id){
			orderRepository.delete(id);
		}

		public Order findOrderById(int id){
			return orderRepository.findOne(id);
		}


		public List<Order> findAllByUser(User user) {


			return orderRepository.findAllByuser(user);

		}
		public List<Order> findUserByDepartmentAndUserRole(int departmentId,String role) {


			return orderRepository.findUserByDepartmentAndUserRole(departmentId,role);

		}



		public List<Order> findAllByTerm(Term term){

			return orderRepository.findAllByTerm(term);

		}

		public List<Order> findOrderByDepartmentAndTermAndUser(int departmentId,int userId,Term termId){
			return orderRepository.findOrderByDepartmentAndTermAndUser(departmentId,userId,termId);
		}
}
