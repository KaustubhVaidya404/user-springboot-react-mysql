package com.root.main.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.root.main.models.User;
import com.root.main.repository.UserDataRepository;

@Service
public class UserDataService {
	
	@Autowired
	UserDataRepository repo;

	public boolean create(User user) {
		repo.save(user);
		return true;
	}
	
	public void update(User user) {
		repo.save(user);
	}
	
	public boolean delete(int id) {
		User user = repo.findById(id).get();
		if(user == null) 
			return false;
		repo.delete(user);
		return true;
	}
	
	public List<User> getAllByName(String name){
		List<User> userList = repo.findAllByName(name);
		return userList;
	}
	
}
