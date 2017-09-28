package com.example.springStarter.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.springStarter.model.Term;

@Repository
public interface TermRepository  extends CrudRepository<Term, Integer> {



}
