package com.example.springStarter.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.springStarter.dao.DepartmentRepository;
import com.example.springStarter.model.Department;



@Service
@Transactional
public class DepartmentService {

	
		
		private final DepartmentRepository departmentRepository;
		
		
		public DepartmentService(DepartmentRepository departmentRepository){
			this.departmentRepository=departmentRepository;
		}
		
		public List<Department> findAll(){
			List<Department> departments = new ArrayList<>();
			
			for(Department department: departmentRepository.findAll()){
				departments.add(department);
			}
			return departments;
		}
		
		public void save(Department department){
			departmentRepository.save(department);
		}
		
		public void delete(int id){
			departmentRepository.delete(id);
		}

		public Department finddepartmentById(int id){
			return departmentRepository.findOne(id);
		}
		
		

	

}
