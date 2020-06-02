package com.satyaApp.crudRedis.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.satyaApp.crudRedis.entity.User;
import com.satyaApp.crudRedis.repository.UserRepository;

@Service
public class CrudApiService {

	@Autowired
	private UserRepository userRepository;

	public List<User> retriveAllUsers() {
		 List<User> users = new ArrayList<>();
		 userRepository.findAll().forEach(f -> users.add(f));
	        return users;
	}

	public User createUser(User user) {
		return userRepository.save(user);
	}
	
	public User updateUser(long id,User user) {
		Optional<User> userObject = userRepository.findById(id);
		if(userObject.isPresent()) {
			user.setId(id);
			return createUser(user);
		}
		return null;
	}
	
	public void removeUser(long id) {
		userRepository.deleteById(id);
	}

	public User retriveUser(long userId) {
		
		return userRepository.findById(userId).get();
	}
}
