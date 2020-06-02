package com.satyaApp.crudRedis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.satyaApp.crudRedis.entity.User;
import com.satyaApp.crudRedis.service.CrudApiService;

@RestController
@RequestMapping("/crud")
public class CrudApiController {
	
	@Autowired
	private CrudApiService crudApiService;
	
	@GetMapping("/users")
	public List<User> retriveAllUsers() {
		return crudApiService.retriveAllUsers();
	}
	
	@Cacheable(value = "user", key = "#userId")
	@GetMapping("/user/{userId}")
	public User retriveUser(@PathVariable final long userId) {
		return crudApiService.retriveUser(userId);
	}
	
	@PostMapping("/user")
	public User createUser(@RequestBody final User user) {
		return crudApiService.createUser(user);
	}
	
	@CachePut(value = "user", key = "#id")
	@PutMapping("/user/{id}")
	public User updateUser(@PathVariable final long id,@RequestBody final User user) {
		return crudApiService.updateUser(id,user);
	}
	
	@DeleteMapping("/user/{id}")
	public void removeUser(@PathVariable final long id) {
		crudApiService.removeUser(id);
	}
}
