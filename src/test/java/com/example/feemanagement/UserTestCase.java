package com.example.feemanagement;


import org.junit.jupiter.api.Assertions;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.university.feemanagement.entities.User;
import com.university.feemanagement.repositories.UserRepository;


@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
@Rollback(true)
class UserTestCase {

	@Autowired
	private UserRepository repo;
	
	@Test
	void testCreateUser() {
		User u=new User();
		u.setRole("STUDENT");
		u.setUsername("bb@g.com");
		u.setPassword("abc@12345");
		User savedUser=repo.save(u);
	    Assertions.assertNotNull(savedUser);
	}
	
	@Test
	void testGetUserById() {
		int id=1;
		Optional<User> list=repo.findById(id);
		User u = null;
		if(list.isPresent()) {
			u= list.get();
		}
		assertThat(u.getUserid()).isEqualTo(id);
	}
}