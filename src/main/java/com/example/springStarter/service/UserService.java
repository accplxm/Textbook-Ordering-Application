package com.example.springStarter.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.springStarter.dao.UserRepository;
import com.example.springStarter.model.User;



@Service
@Transactional
public class UserService {



		private final UserRepository userRepository;


		public UserService(UserRepository userRepository){
			this.userRepository=userRepository;
		}

		public List<User> findAll(){
			List<User> users = new ArrayList<>();

			for(User user: userRepository.findAll()){
				users.add(user);
			}
			return users;
		}

		public User save(User user){
			return userRepository.save(user);
		}

		public void delete(int id){
			userRepository.delete(id);
		}

		public User finduserById(int id){
			return userRepository.findOne(id);
		}

		public List<User> finduserByEmail(String email){
			return userRepository.findAllByEmailidIgnoreCase(email);
		}



}
