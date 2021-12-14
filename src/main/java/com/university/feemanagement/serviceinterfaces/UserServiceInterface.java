package com.university.feemanagement.serviceinterfaces;


import com.university.feemanagement.entities.Student;
import com.university.feemanagement.entities.User;

public interface UserServiceInterface {

	public void saveOrUpdate(Student student);
	public User getUserById(int id);
}

