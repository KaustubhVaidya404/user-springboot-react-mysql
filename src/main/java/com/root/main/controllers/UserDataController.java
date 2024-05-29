package com.root.main.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.root.main.exceptions.UserNotFoundException;
import com.root.main.models.ErrorDetail;
import com.root.main.models.ResponseMessage;
import com.root.main.models.User;
import com.root.main.services.UserDataService;

@RestController
@RequestMapping("/api/v1")
public class UserDataController {
	
	@Autowired
	UserDataService service;

	

	@CrossOrigin(origins = "http://localhost:5173/")
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
	
	@CrossOrigin(origins = "http://localhost:5173/allusers/")
	@DeleteMapping("/delete")
	public ResponseMessage delete(@RequestParam("id") int id) {
		
		boolean flag = service.delete(id);
		
		ResponseMessage responseMessage = new ResponseMessage();
		
		if(flag == true) {
			responseMessage.setMessage("Record Deleted");
			responseMessage.setStatus(HttpStatus.NO_CONTENT);
		}else {
			throw new UserNotFoundException();
		}
		
		return responseMessage;
	}
	
	@CrossOrigin(origins = "http://localhost:5173/")
	@PutMapping("/update")
	public ResponseMessage update(@RequestParam("id") int id, @RequestParam("name") String name, @RequestParam("number") long number,
			@RequestParam("email") String email) {
		
		boolean flag = service.update(id, name, number, email);
		
		ResponseMessage responseMessage = new ResponseMessage();
		
		if(flag == true) {
			responseMessage.setMessage("Record Updated");
			responseMessage.setStatus(HttpStatus.ACCEPTED);
		}else {
			responseMessage.setMessage("Error");
			responseMessage.setStatus(HttpStatus.NOT_FOUND);
		}
		
		return responseMessage;
	}
	
	@CrossOrigin(origins = "http://localhost:5173/")
	@GetMapping("/getByName")
	public List<User> getByName(@RequestParam("name") String name){
		
		List<User> list = service.getAllByName(name);
		
		return list;
	}
	
	@CrossOrigin(origins = "http://localhost:5173/")
	@GetMapping("/getall")
	public Iterable<User> getAll(){
		Iterable<User> userList = service.getAll();
		return userList;
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ErrorDetail> handleUserNotFoundException(Exception exception) {
		ErrorDetail error = new ErrorDetail("Enter user doesnot exisit", HttpStatus.NOT_FOUND);
		ResponseEntity<ErrorDetail> rs = new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
		return rs;
	}
	
	
}
