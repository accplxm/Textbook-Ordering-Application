package com.example.springStarter.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.springStarter.model.Order;

@Repository
public interface OrderRepository  extends CrudRepository<Order, Integer> {



}
