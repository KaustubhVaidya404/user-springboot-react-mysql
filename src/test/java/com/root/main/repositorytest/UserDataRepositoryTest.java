package com.root.main.repositorytest;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.root.main.models.User;
import com.root.main.repository.UserDataRepository;

@DataJpaTest
public class UserDataRepositoryTest {

	@Autowired
	private UserDataRepository repo;
	
	@Test
	public void createDataTest() {
		User user = new User();
		user.setName("Test User One");
		user.setNumber(99224504);
		user.setEmail("TestUserOne@User.com");
		
		repo.save(user);
		
		Assertions.assertThat(user.getId()).isGreaterThan(0);
		
	}
}
