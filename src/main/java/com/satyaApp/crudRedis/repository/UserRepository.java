package com.satyaApp.crudRedis.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.satyaApp.crudRedis.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

}
