package com.root.main.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.root.main.models.ResponseMessage;
import com.root.main.models.User;
import com.root.main.services.UserDataService;

@RestController
public class UserDataController {
	
	@Autowired
	UserDataService service;

	

	@PostMapping("/create")
	public ResponseMessage create(@RequestParam("name") String name, @RequestParam("number") long number,
			@RequestParam("email") String email) {
		
		User user = new User();
		user.setName(name);
		user.setNumber(number);
		user.setEmail(email);
		
		boolean flag = service.create(user);
		
		ResponseMessage responseMessage = new ResponseMessage();
		
		if(flag == true){
			responseMessage.setMessage("Record Created");
			responseMessage.setStatus(HttpStatus.CREATED);
		}else {
			responseMessage.setMessage("Error");
			responseMessage.setStatus(HttpStatus.EXPECTATION_FAILED);
		} // Add custom exception
		
		return responseMessage;
	}
}
