package com.example.springStarter.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.springStarter.dao.OrderRepository;
import com.example.springStarter.model.Order;



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

		public void save(Order order){
			orderRepository.save(order);
		}

		public void delete(int id){
			orderRepository.delete(id);
		}

		public Order findOrderById(int id){
			return orderRepository.findOne(id);
		}





}
