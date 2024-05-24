package com.root.main.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.root.main.models.User;

@Repository
public interface UserDataRepository extends CrudRepository<User, Integer> {

	
	List<User> findAllByName(String namw);
}
