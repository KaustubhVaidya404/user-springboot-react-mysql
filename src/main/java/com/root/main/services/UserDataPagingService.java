package com.root.main.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.root.main.models.User;
import com.root.main.repository.UserDataPagingRepository;

import jakarta.servlet.http.HttpSession;

@Service
public class UserDataPagingService {

	@Autowired
	UserDataPagingRepository repo;
	
	public List<User> getNext(HttpSession session){
		
		Integer page = (Integer) session.getAttribute("page");
		
		if(page == null) {
			page = 0;
			session.setAttribute("page", page);
		}else {
			page++;
			session.setAttribute("page", page);
		}
		
		List<User> userList = repo.findAll(PageRequest.of(page, 5)).getContent();
		
		return userList;
	}
	
	public List<User> getPrevious(HttpSession session){
		
		Integer page = (Integer) session.getAttribute("page");
		
		if(page == null) {
			page = 0;
			session.setAttribute("page", page);
		}else {
			if(page != 0) {
				page--;
				session.setAttribute("page", page);
			}
		}
		
		List<User> userList = repo.findAll(PageRequest.of(page, 5)).getContent();
		
		return userList;
	}
}
