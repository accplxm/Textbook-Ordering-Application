package com.example.springStarter.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.springStarter.dao.ClassorderRepository;
import com.example.springStarter.model.ClassOrder;
import com.example.springStarter.model.Course;
import com.example.springStarter.model.Order;
import com.example.springStarter.model.Textbook;



@Service
@Transactional
public class ClassOrderService {



		private final ClassorderRepository classorderRepository;


		public ClassOrderService(ClassorderRepository classorderRepository){
			this.classorderRepository=classorderRepository;
		}

		public List<ClassOrder> findAll(){
			List<ClassOrder> classorders = new ArrayList<>();

			for(ClassOrder classOrder: classorderRepository.findAll()){
				classorders.add(classOrder);
			}
			return classorders;
		}

		public ClassOrder save(ClassOrder classOrder){
			return classorderRepository.save(classOrder);
		}

		public void delete(int id){
			classorderRepository.delete(id);
		}

		public ClassOrder findClassOrderById(int id){
			return classorderRepository.findOne(id);
		}



		public List<ClassOrder> findAllByCourseAndOrderAndTextbook(Course course, Order order,Textbook textbook){
			return classorderRepository.findAllByCourseAndOrderAndTextbook(course,order,textbook);
		}

}
