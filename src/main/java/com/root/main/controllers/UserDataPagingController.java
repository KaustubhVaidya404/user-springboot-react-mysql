package com.root.main.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.root.main.models.User;
import com.root.main.services.UserDataPagingService;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/api/v1")
public class UserDataPagingController {

	
	@Autowired 
	UserDataPagingService service;
	
	@CrossOrigin(origins = "http://localhost:5173/userpaging")
	@GetMapping("/getnext")
	public List<User> getNext(HttpSession session){
		List<User> userList = service.getNext(session);
		return userList;
	}
	
	@CrossOrigin(origins = "http://localhost:5173/userpaging")
	@GetMapping("/getprev")
	public List<User> getPrev(HttpSession session){
		List<User> userList = service.getPrevious(session);
		return userList;
	}
}
