package com.example.springStarter.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.springStarter.dao.TextbookRepository;
import com.example.springStarter.model.Textbook;



@Service
@Transactional
public class TextbookService {



		private final TextbookRepository textbookRepository;


		public TextbookService(TextbookRepository textbookRepository){
			this.textbookRepository=textbookRepository;
		}

		public List<Textbook> findAll(){
			List<Textbook> textbooks = new ArrayList<>();

			for(Textbook textbook: textbookRepository.findAll()){
				textbooks.add(textbook);
			}
			return textbooks;
		}

		public Textbook save(Textbook textbook){
			return textbookRepository.save(textbook);
		}

		public void delete(int id){
			textbookRepository.delete(id);
		}

		public Textbook findTextbookById(int id){
			return textbookRepository.findOne(id);
		}



		public List<Textbook> findTextbooksByTermAndCourse(int termId,int courseId,int orderId){
			return textbookRepository.findTextbooksByTermAndCourse(termId, courseId,orderId);
		}

		public List<Textbook> findAllByTitleAndAuthorAndCopyrightAndEditionAndIsbnAndPublisher(String title, String author,String copyright, String edition,String isbn,String publisher){
			return textbookRepository.findAllByTitleAndAuthorAndCopyrightAndEditionAndIsbnAndPublisher(title,author,copyright,edition,isbn,publisher);
		}



}
