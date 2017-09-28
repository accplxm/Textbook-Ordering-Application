package com.example.springStarter.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.springStarter.model.Textbook;

@Repository
public interface TextbookRepository  extends CrudRepository<Textbook, Integer> {



}
