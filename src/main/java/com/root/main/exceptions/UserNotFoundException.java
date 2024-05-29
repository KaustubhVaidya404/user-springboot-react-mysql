package com.root.main.exceptions;

public class UserNotFoundException extends RuntimeException{

	@Override
	public String toString() {
		return "User Data Not Found";
	}
	
}
