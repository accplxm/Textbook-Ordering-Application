package com.example.springStarter.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.springStarter.dao.TermRepository;
import com.example.springStarter.model.Term;
import com.example.springStarter.model.User;



@Service
@Transactional
public class TermService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

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
			if(findtermsBySemesterAndYear(term.getYear(),term.getSemester()).isEmpty()){
			termRepository.save(term);
			}else{
			logger.debug("Term is already present so ignoring the save");
			}
		}

		public void delete(int id){
			termRepository.delete(id);
		}

		public Term findtermById(int id){
			return termRepository.findOne(id);
		}
		public List<Term> findtermsBySemesterAndYear(int year,String semester){
			return termRepository.findBySemesterAndYear(semester,year);
		}

		}

