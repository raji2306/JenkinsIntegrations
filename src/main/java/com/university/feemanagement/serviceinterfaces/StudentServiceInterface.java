package com.university.feemanagement.serviceinterfaces;


	import java.util.List;

import com.university.feemanagement.entities.Student;

	public interface StudentServiceInterface {

		public List<Student> getAllStudent();
		public void deleteStudent(int id);
		public void saveOrUpdate(Student student);
		public Student getStudentById(int id);
		
	}
