package com.university.feemanagement.services;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.university.feemanagement.entities.Student;
import com.university.feemanagement.entities.User;
import com.university.feemanagement.repositories.UserRepository;
import com.university.feemanagement.serviceinterfaces.UserServiceInterface;

@Service
@Transactional
public class UserService implements UserServiceInterface{

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Override
	public void saveOrUpdate(Student student) {
		User usr = new User();
		usr.setUsername(student.getRrn() + "@abc.com");
		usr.setPassword(passwordEncoder.encode("abc@123"));
		usr.setRole("ROLE_USER");
		userRepo.save(usr);
	}

	@Override 
	public User getUserById(int id) {
		Optional<User> list = userRepo.findById(id);
		User u = null;
		if(list.isPresent()) {
			u = list.get();
		}
		return u;
	}

}

