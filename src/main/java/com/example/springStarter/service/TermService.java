package com.example.springStarter.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.springStarter.dao.TermRepository;
import com.example.springStarter.model.Term;



@Service
@Transactional
public class TermService {



		private final TermRepository termRepository;


		public TermService(TermRepository termRepository){
			this.termRepository=termRepository;
		}

		public List<Term> findAll(){
			List<Term> terms = new ArrayList<>();

			for(Term term: termRepository.findAll()){
				terms.add(term);
			}
			return terms;
		}

		public void save(Term term){
			termRepository.save(term);
		}

		public void delete(int id){
			termRepository.delete(id);
		}

		public Term findtermById(int id){
			return termRepository.findOne(id);
		}





}
